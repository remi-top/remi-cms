package ai.remi.cms.web.controller;


import ai.remi.cms.domain.converter.ContentCommentConverter;
import ai.remi.cms.domain.dto.post.ContentCommentPostDTO;
import ai.remi.cms.domain.dto.put.ContentCommentPutDTO;
import ai.remi.cms.domain.entity.ContentComment;
import ai.remi.cms.domain.query.ContentCommentQuery;
import ai.remi.cms.domain.vo.ContentCommentVO;
import ai.remi.cms.server.service.ContentCommentService;
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
 * @desc 评论记录(ContentComment)控制层
 */
@Validated
@RestController
@ApiSort(value = 1)
@Tag(name = "评论记录")
@RequestMapping("contentComment")
public class ContentCommentController {
    /**
     * 服务对象
     */
    @Resource
    private ContentCommentService contentCommentService;


    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    @Operation(summary = "查询单条")
    public ResultBean<ContentCommentVO> get(@PathVariable @Validated @NotBlank(message = "ID不能为空") String id) {
        ContentComment contentComment = contentCommentService.getById(id);
        //处理格式转换
        ContentCommentVO contentCommentVO = ContentCommentConverter.INSTANT.entityToVO(contentComment);
        return ResultBean.success(contentCommentVO);
    }

    /**
     * 通过实体不为空的属性作为筛选条件查询对象列表
     *
     * @param contentCommentQuery 实例对象
     * @return 对象列表
     */
    @PostMapping(value = "/list")
    @Operation(summary = "查询所有")
    public ResultBean<List<ContentCommentVO>> list(@RequestBody ContentCommentQuery contentCommentQuery) {
        //处理格式转换
        ContentComment contentComment = ContentCommentConverter.INSTANT.queryToEntity(contentCommentQuery);
        //执行分页查询
        List<ContentComment> listResult = contentCommentService.list(new QueryWrapper<>(contentComment));
        return ResultBean.success(BeanCopyUtils.coverList(listResult, ContentCommentVO.class));
    }

    /**
     * 分页查询所有数据
     *
     * @param pageQuery           分页对象
     * @param contentCommentQuery 查询实体
     * @return 分页对象
     */
    @PostMapping(value = "/page")
    @Operation(summary = "分页查询")
    public ResultBean<PagerBean<ContentCommentVO>> page(PageQuery pageQuery, ContentCommentQuery contentCommentQuery) {
        //处理分页条件
        Page<ContentComment> page = new Page<>(pageQuery.getPageNum(), pageQuery.getPageSize());
        //处理格式转换
        ContentComment contentComment = ContentCommentConverter.INSTANT.queryToEntity(contentCommentQuery);
        //执行分页查询
        Page<ContentComment> pageResult = contentCommentService.page(page, new QueryWrapper<>(contentComment));
        PagerBean<ContentCommentVO> pageBean = new PagerBean<>(pageResult.getTotal(), pageResult.getCurrent(),
                pageResult.getSize(), BeanCopyUtils.coverList(pageResult.getRecords(), ContentCommentVO.class));
        return ResultBean.success(pageBean);
    }

    /**
     * 新增数据
     *
     * @param contentCommentDTO 实体对象
     * @return 新增结果
     */
    @PostMapping("/add")
    @Operation(summary = "新增数据")
    public ResultBean<Boolean> insert(@RequestBody @Validated ContentCommentPostDTO contentCommentDTO) {
        //处理格式转换
        ContentComment contentComment = ContentCommentConverter.INSTANT.postDtoToEntity(contentCommentDTO);
        //执行数据保存
        return ResultBean.success(contentCommentService.save(contentComment));
    }

    /**
     * 修改数据
     *
     * @param contentCommentDTO 实体对象
     * @return 修改结果
     */
    @PutMapping("/update")
    @Operation(summary = "修改数据")
    public ResultBean<Boolean> update(@RequestBody @Validated ContentCommentPutDTO contentCommentDTO) {
        //处理格式转换
        ContentComment contentComment = ContentCommentConverter.INSTANT.putDtoToEntity(contentCommentDTO);
        //执行数据更新
        return ResultBean.success(contentCommentService.updateById(contentComment));
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
        return ResultBean.success(contentCommentService.removeByIds(ids));
    }

}

