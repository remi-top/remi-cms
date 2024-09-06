package ai.remi.cms.web.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import ai.remi.cms.domain.converter.TagConverter;
import ai.remi.cms.domain.dto.post.TagPostDTO;
import ai.remi.cms.domain.dto.put.TagPutDTO;
import ai.remi.cms.domain.entity.Tag;
import ai.remi.cms.domain.query.TagQuery;
import ai.remi.cms.domain.vo.TagVO;
import ai.remi.cms.server.service.TagService;
import ai.remi.comm.core.result.PagerBean;
import ai.remi.comm.core.result.ResultBean;
import ai.remi.comm.domain.query.PageQuery;
import ai.remi.comm.util.bean.BeanCopyUtils;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.constraints.NotBlank;
import java.util.List;

/**
 * @author DianJiu
 * @email dianjiuxyz@gmail.com
 * @desc 标签管理(Tag)控制层
 */
@Validated
@RestController
@ApiSort(value = 1)
@io.swagger.v3.oas.annotations.tags.Tag(name = "标签管理")
@RequestMapping("tag")
public class TagController {
    /**
     * 服务对象
     */
    @Resource
    private TagService tagService;


    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    @Operation(summary = "查询单条")
    public ResultBean<TagVO> get(@PathVariable @Validated @NotBlank(message = "ID不能为空") String id) {
        Tag tag = tagService.getById(id);
        //处理格式转换
        TagVO tagVO = TagConverter.INSTANT.entityToVO(tag);
        return ResultBean.success(tagVO);
    }

    /**
     * 通过实体不为空的属性作为筛选条件查询对象列表
     *
     * @param tagQuery 实例对象
     * @return 对象列表
     */
    @PostMapping(value = "/list")
    @Operation(summary = "查询所有")
    public ResultBean<List<TagVO>> list(@RequestBody TagQuery tagQuery) {
        //处理格式转换
        Tag tag = TagConverter.INSTANT.queryToEntity(tagQuery);
        //执行分页查询
        List<Tag> listResult = tagService.list(new QueryWrapper<>(tag));
        return ResultBean.success(BeanCopyUtils.coverList(listResult, TagVO.class));
    }

    /**
     * 分页查询所有数据
     *
     * @param pageQuery 分页对象
     * @param tagQuery  查询实体
     * @return 分页对象
     */
    @PostMapping(value = "/page")
    @Operation(summary = "分页查询")
    public ResultBean<PagerBean<TagVO>> page(PageQuery pageQuery, TagQuery tagQuery) {
        //处理分页条件
        Page<Tag> page = new Page<>(pageQuery.getPageNum(), pageQuery.getPageSize());
        //处理格式转换
        Tag tag = TagConverter.INSTANT.queryToEntity(tagQuery);
        //执行分页查询
        Page<Tag> pageResult = tagService.page(page, new QueryWrapper<>(tag));
        PagerBean<TagVO> pageBean = new PagerBean<>(pageResult.getTotal(), pageResult.getCurrent(),
                pageResult.getSize(), BeanCopyUtils.coverList(pageResult.getRecords(), TagVO.class));
        return ResultBean.success(pageBean);
    }

    /**
     * 新增数据
     *
     * @param tagDTO 实体对象
     * @return 新增结果
     */
    @PostMapping("/add")
    @Operation(summary = "新增数据")
    public ResultBean<Boolean> insert(@RequestBody @Validated TagPostDTO tagDTO) {
        //处理格式转换
        Tag tag = TagConverter.INSTANT.postDtoToEntity(tagDTO);
        //执行数据保存
        return ResultBean.success(tagService.save(tag));
    }

    /**
     * 修改数据
     *
     * @param tagDTO 实体对象
     * @return 修改结果
     */
    @PutMapping("/update")
    @Operation(summary = "修改数据")
    public ResultBean<Boolean> update(@RequestBody @Validated TagPutDTO tagDTO) {
        //处理格式转换
        Tag tag = TagConverter.INSTANT.putDtoToEntity(tagDTO);
        //执行数据更新
        return ResultBean.success(tagService.updateById(tag));
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
        return ResultBean.success(tagService.removeByIds(ids));
    }

}

