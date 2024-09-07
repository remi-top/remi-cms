package ai.remi.cms.web.controller;


import ai.remi.cms.domain.converter.CarouselConverter;
import ai.remi.cms.domain.dto.post.CarouselPostDTO;
import ai.remi.cms.domain.dto.put.CarouselPutDTO;
import ai.remi.cms.domain.entity.Carousel;
import ai.remi.cms.domain.query.CarouselQuery;
import ai.remi.cms.domain.vo.CarouselVO;
import ai.remi.cms.server.service.CarouselService;
import ai.remi.comm.core.result.PagerBean;
import ai.remi.comm.core.result.ResultBean;
import ai.remi.comm.domain.query.PageQuery;
import ai.remi.comm.util.bean.BeanCopyUtils;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.constraints.NotBlank;
import java.util.List;

/**
 * @author DianJiu
 * @email dianjiuxyz@gmail.com
 * @desc 轮播管理(Carousel)控制层
 */
@Validated
@RestController
@ApiSort(value = 1)
@Tag(name = "轮播管理")
@RequestMapping("carousel")
public class CarouselController {
    /**
     * 服务对象
     */
    @Resource
    private CarouselService carouselService;


    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    @Operation(summary = "查询单条")
    public ResultBean<CarouselVO> get(@PathVariable @Validated @NotBlank(message = "ID不能为空") String id) {
        Carousel carousel = carouselService.getById(id);
        //处理格式转换
        CarouselVO carouselVO = CarouselConverter.INSTANT.entityToVO(carousel);
        return ResultBean.success(carouselVO);
    }

    /**
     * 通过实体不为空的属性作为筛选条件查询对象列表
     *
     * @param carouselQuery 实例对象
     * @return 对象列表
     */
    @PostMapping(value = "/list")
    @Operation(summary = "查询所有")
    public ResultBean<List<CarouselVO>> list(@RequestBody CarouselQuery carouselQuery) {
        //处理格式转换
        Carousel carousel = CarouselConverter.INSTANT.queryToEntity(carouselQuery);
        //执行分页查询
        List<Carousel> listResult = carouselService.list(new QueryWrapper<>(carousel));
        return ResultBean.success(BeanCopyUtils.coverList(listResult, CarouselVO.class));
    }

    /**
     * 分页查询所有数据
     *
     * @param pageQuery     分页对象
     * @param carouselQuery 查询实体
     * @return 分页对象
     */
    @PostMapping(value = "/page")
    @Operation(summary = "分页查询")
    public ResultBean<PagerBean<CarouselVO>> page(PageQuery pageQuery, CarouselQuery carouselQuery) {
        //处理分页条件
        Page<Carousel> page = new Page<>(pageQuery.getPageNum(), pageQuery.getPageSize());
        //处理格式转换
        Carousel carousel = CarouselConverter.INSTANT.queryToEntity(carouselQuery);
        //执行分页查询
        Page<Carousel> pageResult = carouselService.page(page, new QueryWrapper<>(carousel));
        PagerBean<CarouselVO> pageBean = new PagerBean<>(pageResult.getTotal(), pageResult.getCurrent(),
                pageResult.getSize(), BeanCopyUtils.coverList(pageResult.getRecords(), CarouselVO.class));
        return ResultBean.success(pageBean);
    }

    /**
     * 新增数据
     *
     * @param carouselDTO 实体对象
     * @return 新增结果
     */
    @PostMapping("/add")
    @Operation(summary = "新增数据")
    public ResultBean<Boolean> insert(@RequestBody @Validated CarouselPostDTO carouselDTO) {
        //处理格式转换
        Carousel carousel = CarouselConverter.INSTANT.postDtoToEntity(carouselDTO);
        //执行数据保存
        return ResultBean.success(carouselService.save(carousel));
    }

    /**
     * 修改数据
     *
     * @param carouselDTO 实体对象
     * @return 修改结果
     */
    @PutMapping("/update")
    @Operation(summary = "修改数据")
    public ResultBean<Boolean> update(@RequestBody @Validated CarouselPutDTO carouselDTO) {
        //处理格式转换
        Carousel carousel = CarouselConverter.INSTANT.putDtoToEntity(carouselDTO);
        //执行数据更新
        return ResultBean.success(carouselService.updateById(carousel));
    }

    /**
     * 删除数据
     *
     * @param ids 主键结合
     * @return 删除结果
     */
    @DeleteMapping("/delete")
    @Operation(summary = "删除数据")
    public ResultBean<Boolean> delete(@RequestParam("ids") List<String> ids) {
        return ResultBean.success(carouselService.removeByIds(ids));
    }

}

