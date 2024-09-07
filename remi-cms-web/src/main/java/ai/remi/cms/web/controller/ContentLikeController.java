package ai.remi.cms.web.controller;


import ai.remi.cms.domain.converter.ContentLikeConverter;
import ai.remi.cms.domain.dto.post.ContentLikePostDTO;
import ai.remi.cms.domain.dto.put.ContentLikePutDTO;
import ai.remi.cms.domain.entity.ContentLike;
import ai.remi.cms.domain.query.ContentLikeQuery;
import ai.remi.cms.domain.vo.ContentLikeVO;
import ai.remi.cms.server.service.ContentLikeService;
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
 * @desc 点赞记录(ContentLike)控制层
 */
@Validated
@RestController
@ApiSort(value = 1)
@Tag(name = "点赞记录")
@RequestMapping("contentLike")
public class ContentLikeController {
    /**
     * 服务对象
     */
    @Resource
    private ContentLikeService contentLikeService;


    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    @Operation(summary = "查询单条")
    public ResultBean<ContentLikeVO> get(@PathVariable @Validated @NotBlank(message = "ID不能为空") String id) {
        ContentLike contentLike = contentLikeService.getById(id);
        //处理格式转换
        ContentLikeVO contentLikeVO = ContentLikeConverter.INSTANT.entityToVO(contentLike);
        return ResultBean.success(contentLikeVO);
    }

    /**
     * 通过实体不为空的属性作为筛选条件查询对象列表
     *
     * @param contentLikeQuery 实例对象
     * @return 对象列表
     */
    @PostMapping(value = "/list")
    @Operation(summary = "查询所有")
    public ResultBean<List<ContentLikeVO>> list(@RequestBody ContentLikeQuery contentLikeQuery) {
        //处理格式转换
        ContentLike contentLike = ContentLikeConverter.INSTANT.queryToEntity(contentLikeQuery);
        //执行分页查询
        List<ContentLike> listResult = contentLikeService.list(new QueryWrapper<>(contentLike));
        return ResultBean.success(BeanCopyUtils.coverList(listResult, ContentLikeVO.class));
    }

    /**
     * 分页查询所有数据
     *
     * @param pageQuery        分页对象
     * @param contentLikeQuery 查询实体
     * @return 分页对象
     */
    @PostMapping(value = "/page")
    @Operation(summary = "分页查询")
    public ResultBean<PagerBean<ContentLikeVO>> page(PageQuery pageQuery, ContentLikeQuery contentLikeQuery) {
        //处理分页条件
        Page<ContentLike> page = new Page<>(pageQuery.getPageNum(), pageQuery.getPageSize());
        //处理格式转换
        ContentLike contentLike = ContentLikeConverter.INSTANT.queryToEntity(contentLikeQuery);
        //执行分页查询
        Page<ContentLike> pageResult = contentLikeService.page(page, new QueryWrapper<>(contentLike));
        PagerBean<ContentLikeVO> pageBean = new PagerBean<>(pageResult.getTotal(), pageResult.getCurrent(),
                pageResult.getSize(), BeanCopyUtils.coverList(pageResult.getRecords(), ContentLikeVO.class));
        return ResultBean.success(pageBean);
    }

    /**
     * 新增数据
     *
     * @param contentLikeDTO 实体对象
     * @return 新增结果
     */
    @PostMapping("/add")
    @Operation(summary = "新增数据")
    public ResultBean<Boolean> insert(@RequestBody @Validated ContentLikePostDTO contentLikeDTO) {
        //处理格式转换
        ContentLike contentLike = ContentLikeConverter.INSTANT.postDtoToEntity(contentLikeDTO);
        //执行数据保存
        return ResultBean.success(contentLikeService.save(contentLike));
    }

    /**
     * 修改数据
     *
     * @param contentLikeDTO 实体对象
     * @return 修改结果
     */
    @PutMapping("/update")
    @Operation(summary = "修改数据")
    public ResultBean<Boolean> update(@RequestBody @Validated ContentLikePutDTO contentLikeDTO) {
        //处理格式转换
        ContentLike contentLike = ContentLikeConverter.INSTANT.putDtoToEntity(contentLikeDTO);
        //执行数据更新
        return ResultBean.success(contentLikeService.updateById(contentLike));
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
        return ResultBean.success(contentLikeService.removeByIds(ids));
    }

}

