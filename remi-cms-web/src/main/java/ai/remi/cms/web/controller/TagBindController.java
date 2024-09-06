package ai.remi.cms.web.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import ai.remi.cms.domain.converter.TagBindConverter;
import ai.remi.cms.domain.dto.post.TagBindPostDTO;
import ai.remi.cms.domain.dto.put.TagBindPutDTO;
import ai.remi.cms.domain.entity.TagBind;
import ai.remi.cms.domain.query.TagBindQuery;
import ai.remi.cms.domain.vo.TagBindVO;
import ai.remi.cms.server.service.TagBindService;
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
 * @desc 标签绑定(TagBind)控制层
 */
@Validated
@RestController
@ApiSort(value = 1)
@Tag(name = "标签绑定")
@RequestMapping("tagBind")
public class TagBindController {
    /**
     * 服务对象
     */
    @Resource
    private TagBindService tagBindService;


    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    @Operation(summary = "查询单条")
    public ResultBean<TagBindVO> get(@PathVariable @Validated @NotBlank(message = "ID不能为空") String id) {
        TagBind tagBind = tagBindService.getById(id);
        //处理格式转换
        TagBindVO tagBindVO = TagBindConverter.INSTANT.entityToVO(tagBind);
        return ResultBean.success(tagBindVO);
    }

    /**
     * 通过实体不为空的属性作为筛选条件查询对象列表
     *
     * @param tagBindQuery 实例对象
     * @return 对象列表
     */
    @PostMapping(value = "/list")
    @Operation(summary = "查询所有")
    public ResultBean<List<TagBindVO>> list(@RequestBody TagBindQuery tagBindQuery) {
        //处理格式转换
        TagBind tagBind = TagBindConverter.INSTANT.queryToEntity(tagBindQuery);
        //执行分页查询
        List<TagBind> listResult = tagBindService.list(new QueryWrapper<>(tagBind));
        return ResultBean.success(BeanCopyUtils.coverList(listResult, TagBindVO.class));
    }

    /**
     * 分页查询所有数据
     *
     * @param pageQuery    分页对象
     * @param tagBindQuery 查询实体
     * @return 分页对象
     */
    @PostMapping(value = "/page")
    @Operation(summary = "分页查询")
    public ResultBean<PagerBean<TagBindVO>> page(PageQuery pageQuery, TagBindQuery tagBindQuery) {
        //处理分页条件
        Page<TagBind> page = new Page<>(pageQuery.getPageNum(), pageQuery.getPageSize());
        //处理格式转换
        TagBind tagBind = TagBindConverter.INSTANT.queryToEntity(tagBindQuery);
        //执行分页查询
        Page<TagBind> pageResult = tagBindService.page(page, new QueryWrapper<>(tagBind));
        PagerBean<TagBindVO> pageBean = new PagerBean<>(pageResult.getTotal(), pageResult.getCurrent(),
                pageResult.getSize(), BeanCopyUtils.coverList(pageResult.getRecords(), TagBindVO.class));
        return ResultBean.success(pageBean);
    }

    /**
     * 新增数据
     *
     * @param tagBindDTO 实体对象
     * @return 新增结果
     */
    @PostMapping("/add")
    @Operation(summary = "新增数据")
    public ResultBean<Boolean> insert(@RequestBody @Validated TagBindPostDTO tagBindDTO) {
        //处理格式转换
        TagBind tagBind = TagBindConverter.INSTANT.postDtoToEntity(tagBindDTO);
        //执行数据保存
        return ResultBean.success(tagBindService.save(tagBind));
    }

    /**
     * 修改数据
     *
     * @param tagBindDTO 实体对象
     * @return 修改结果
     */
    @PutMapping("/update")
    @Operation(summary = "修改数据")
    public ResultBean<Boolean> update(@RequestBody @Validated TagBindPutDTO tagBindDTO) {
        //处理格式转换
        TagBind tagBind = TagBindConverter.INSTANT.putDtoToEntity(tagBindDTO);
        //执行数据更新
        return ResultBean.success(tagBindService.updateById(tagBind));
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
        return ResultBean.success(tagBindService.removeByIds(ids));
    }

}

