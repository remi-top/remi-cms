package ai.remi.cms.web.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import ai.remi.cms.domain.converter.ImageConverter;
import ai.remi.cms.domain.dto.post.ImagePostDTO;
import ai.remi.cms.domain.dto.put.ImagePutDTO;
import ai.remi.cms.domain.entity.Image;
import ai.remi.cms.domain.query.ImageQuery;
import ai.remi.cms.domain.vo.ImageVO;
import ai.remi.cms.server.service.ImageService;
import ai.remi.comm.core.result.PagerBean;
import ai.remi.comm.core.result.ResultBean;
import ai.remi.comm.domain.query.PageQuery;
import ai.remi.comm.util.bean.BeanCopyUtils;
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
 * @desc 图片管理(Image)控制层
 */
@Validated
@RestController
@ApiSort(value = 1)
@Tag(name = "图片管理")
@RequestMapping("image")
public class ImageController {
    /**
     * 服务对象
     */
    @Resource
    private ImageService imageService;


    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    @Operation(summary = "查询单条")
    public ResultBean<ImageVO> get(@PathVariable @Validated @NotBlank(message = "ID不能为空") String id) {
        Image image = imageService.getById(id);
        //处理格式转换
        ImageVO imageVO = ImageConverter.INSTANT.entityToVO(image);
        return ResultBean.success(imageVO);
    }

    /**
     * 通过实体不为空的属性作为筛选条件查询对象列表
     *
     * @param imageQuery 实例对象
     * @return 对象列表
     */
    @PostMapping(value = "/list")
    @Operation(summary = "查询所有")
    public ResultBean<List<ImageVO>> list(@RequestBody ImageQuery imageQuery) {
        //处理格式转换
        Image image = ImageConverter.INSTANT.queryToEntity(imageQuery);
        //执行分页查询
        List<Image> listResult = imageService.list(new QueryWrapper<>(image));
        return ResultBean.success(BeanCopyUtils.coverList(listResult, ImageVO.class));
    }

    /**
     * 分页查询所有数据
     *
     * @param pageQuery  分页对象
     * @param imageQuery 查询实体
     * @return 分页对象
     */
    @PostMapping(value = "/page")
    @Operation(summary = "分页查询")
    public ResultBean<PagerBean<ImageVO>> page(PageQuery pageQuery, ImageQuery imageQuery) {
        //处理分页条件
        Page<Image> page = new Page<>(pageQuery.getPageNum(), pageQuery.getPageSize());
        //处理格式转换
        Image image = ImageConverter.INSTANT.queryToEntity(imageQuery);
        //执行分页查询
        Page<Image> pageResult = imageService.page(page, new QueryWrapper<>(image));
        PagerBean<ImageVO> pageBean = new PagerBean<>(pageResult.getTotal(), pageResult.getCurrent(),
                pageResult.getSize(), BeanCopyUtils.coverList(pageResult.getRecords(), ImageVO.class));
        return ResultBean.success(pageBean);
    }

    /**
     * 新增数据
     *
     * @param imageDTO 实体对象
     * @return 新增结果
     */
    @PostMapping("/add")
    @Operation(summary = "新增数据")
    public ResultBean<Boolean> insert(@RequestBody @Validated ImagePostDTO imageDTO) {
        //处理格式转换
        Image image = ImageConverter.INSTANT.postDtoToEntity(imageDTO);
        //执行数据保存
        return ResultBean.success(imageService.save(image));
    }

    /**
     * 修改数据
     *
     * @param imageDTO 实体对象
     * @return 修改结果
     */
    @PutMapping("/update")
    @Operation(summary = "修改数据")
    public ResultBean<Boolean> update(@RequestBody @Validated ImagePutDTO imageDTO) {
        //处理格式转换
        Image image = ImageConverter.INSTANT.putDtoToEntity(imageDTO);
        //执行数据更新
        return ResultBean.success(imageService.updateById(image));
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
        return ResultBean.success(imageService.removeByIds(ids));
    }

}

