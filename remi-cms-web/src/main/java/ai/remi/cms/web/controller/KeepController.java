package ai.remi.cms.web.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import ai.remi.cms.domain.converter.KeepConverter;
import ai.remi.cms.domain.dto.post.KeepPostDTO;
import ai.remi.cms.domain.dto.put.KeepPutDTO;
import ai.remi.cms.domain.entity.Keep;
import ai.remi.cms.domain.query.KeepQuery;
import ai.remi.cms.domain.vo.KeepVO;
import ai.remi.cms.server.service.KeepService;
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
 * @desc 收藏记录(Keep)控制层
 */
@Validated
@RestController
@ApiSort(value = 1)
@Tag(name = "收藏记录")
@RequestMapping("keep")
public class KeepController {
    /**
     * 服务对象
     */
    @Resource
    private KeepService keepService;


    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    @Operation(summary = "查询单条")
    public ResultBean<KeepVO> get(@PathVariable @Validated @NotBlank(message = "ID不能为空") String id) {
        Keep keep = keepService.getById(id);
        //处理格式转换
        KeepVO keepVO = KeepConverter.INSTANT.entityToVO(keep);
        return ResultBean.success(keepVO);
    }

    /**
     * 通过实体不为空的属性作为筛选条件查询对象列表
     *
     * @param keepQuery 实例对象
     * @return 对象列表
     */
    @PostMapping(value = "/list")
    @Operation(summary = "查询所有")
    public ResultBean<List<KeepVO>> list(@RequestBody KeepQuery keepQuery) {
        //处理格式转换
        Keep keep = KeepConverter.INSTANT.queryToEntity(keepQuery);
        //执行分页查询
        List<Keep> listResult = keepService.list(new QueryWrapper<>(keep));
        return ResultBean.success(BeanCopyUtils.coverList(listResult, KeepVO.class));
    }

    /**
     * 分页查询所有数据
     *
     * @param pageQuery 分页对象
     * @param keepQuery 查询实体
     * @return 分页对象
     */
    @PostMapping(value = "/page")
    @Operation(summary = "分页查询")
    public ResultBean<PagerBean<KeepVO>> page(PageQuery pageQuery, KeepQuery keepQuery) {
        //处理分页条件
        Page<Keep> page = new Page<>(pageQuery.getPageNum(), pageQuery.getPageSize());
        //处理格式转换
        Keep keep = KeepConverter.INSTANT.queryToEntity(keepQuery);
        //执行分页查询
        Page<Keep> pageResult = keepService.page(page, new QueryWrapper<>(keep));
        PagerBean<KeepVO> pageBean = new PagerBean<>(pageResult.getTotal(), pageResult.getCurrent(),
                pageResult.getSize(), BeanCopyUtils.coverList(pageResult.getRecords(), KeepVO.class));
        return ResultBean.success(pageBean);
    }

    /**
     * 新增数据
     *
     * @param keepDTO 实体对象
     * @return 新增结果
     */
    @PostMapping("/add")
    @Operation(summary = "新增数据")
    public ResultBean<Boolean> insert(@RequestBody @Validated KeepPostDTO keepDTO) {
        //处理格式转换
        Keep keep = KeepConverter.INSTANT.postDtoToEntity(keepDTO);
        //执行数据保存
        return ResultBean.success(keepService.save(keep));
    }

    /**
     * 修改数据
     *
     * @param keepDTO 实体对象
     * @return 修改结果
     */
    @PutMapping("/update")
    @Operation(summary = "修改数据")
    public ResultBean<Boolean> update(@RequestBody @Validated KeepPutDTO keepDTO) {
        //处理格式转换
        Keep keep = KeepConverter.INSTANT.putDtoToEntity(keepDTO);
        //执行数据更新
        return ResultBean.success(keepService.updateById(keep));
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
        return ResultBean.success(keepService.removeByIds(ids));
    }

}

