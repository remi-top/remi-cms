package ai.remi.cms.web.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import ai.remi.cms.domain.converter.ViewConverter;
import ai.remi.cms.domain.dto.post.ViewPostDTO;
import ai.remi.cms.domain.dto.put.ViewPutDTO;
import ai.remi.cms.domain.entity.View;
import ai.remi.cms.domain.query.ViewQuery;
import ai.remi.cms.domain.vo.ViewVO;
import ai.remi.cms.server.service.ViewService;
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
 * @desc 查看记录(View)控制层
 */
@Validated
@RestController
@ApiSort(value = 1)
@Tag(name = "查看记录")
@RequestMapping("view")
public class ViewController {
    /**
     * 服务对象
     */
    @Resource
    private ViewService viewService;


    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    @Operation(summary = "查询单条")
    public ResultBean<ViewVO> get(@PathVariable @Validated @NotBlank(message = "ID不能为空") String id) {
        View view = viewService.getById(id);
        //处理格式转换
        ViewVO viewVO = ViewConverter.INSTANT.entityToVO(view);
        return ResultBean.success(viewVO);
    }

    /**
     * 通过实体不为空的属性作为筛选条件查询对象列表
     *
     * @param viewQuery 实例对象
     * @return 对象列表
     */
    @PostMapping(value = "/list")
    @Operation(summary = "查询所有")
    public ResultBean<List<ViewVO>> list(@RequestBody ViewQuery viewQuery) {
        //处理格式转换
        View view = ViewConverter.INSTANT.queryToEntity(viewQuery);
        //执行分页查询
        List<View> listResult = viewService.list(new QueryWrapper<>(view));
        return ResultBean.success(BeanCopyUtils.coverList(listResult, ViewVO.class));
    }

    /**
     * 分页查询所有数据
     *
     * @param pageQuery 分页对象
     * @param viewQuery 查询实体
     * @return 分页对象
     */
    @PostMapping(value = "/page")
    @Operation(summary = "分页查询")
    public ResultBean<PagerBean<ViewVO>> page(PageQuery pageQuery, ViewQuery viewQuery) {
        //处理分页条件
        Page<View> page = new Page<>(pageQuery.getPageNum(), pageQuery.getPageSize());
        //处理格式转换
        View view = ViewConverter.INSTANT.queryToEntity(viewQuery);
        //执行分页查询
        Page<View> pageResult = viewService.page(page, new QueryWrapper<>(view));
        PagerBean<ViewVO> pageBean = new PagerBean<>(pageResult.getTotal(), pageResult.getCurrent(),
                pageResult.getSize(), BeanCopyUtils.coverList(pageResult.getRecords(), ViewVO.class));
        return ResultBean.success(pageBean);
    }

    /**
     * 新增数据
     *
     * @param viewDTO 实体对象
     * @return 新增结果
     */
    @PostMapping("/add")
    @Operation(summary = "新增数据")
    public ResultBean<Boolean> insert(@RequestBody @Validated ViewPostDTO viewDTO) {
        //处理格式转换
        View view = ViewConverter.INSTANT.postDtoToEntity(viewDTO);
        //执行数据保存
        return ResultBean.success(viewService.save(view));
    }

    /**
     * 修改数据
     *
     * @param viewDTO 实体对象
     * @return 修改结果
     */
    @PutMapping("/update")
    @Operation(summary = "修改数据")
    public ResultBean<Boolean> update(@RequestBody @Validated ViewPutDTO viewDTO) {
        //处理格式转换
        View view = ViewConverter.INSTANT.putDtoToEntity(viewDTO);
        //执行数据更新
        return ResultBean.success(viewService.updateById(view));
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
        return ResultBean.success(viewService.removeByIds(ids));
    }

}

