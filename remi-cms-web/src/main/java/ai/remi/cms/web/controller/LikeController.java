package ai.remi.cms.web.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import ai.remi.cms.domain.converter.LikeConverter;
import ai.remi.cms.domain.dto.post.LikePostDTO;
import ai.remi.cms.domain.dto.put.LikePutDTO;
import ai.remi.cms.domain.entity.Like;
import ai.remi.cms.domain.query.LikeQuery;
import ai.remi.cms.domain.vo.LikeVO;
import ai.remi.cms.server.service.LikeService;
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
 * @desc 点赞记录(Like)控制层
 */
@Validated
@RestController
@ApiSort(value = 1)
@Tag(name = "点赞记录")
@RequestMapping("like")
public class LikeController {
    /**
     * 服务对象
     */
    @Resource
    private LikeService likeService;


    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    @Operation(summary = "查询单条")
    public ResultBean<LikeVO> get(@PathVariable @Validated @NotBlank(message = "ID不能为空") String id) {
        Like like = likeService.getById(id);
        //处理格式转换
        LikeVO likeVO = LikeConverter.INSTANT.entityToVO(like);
        return ResultBean.success(likeVO);
    }

    /**
     * 通过实体不为空的属性作为筛选条件查询对象列表
     *
     * @param likeQuery 实例对象
     * @return 对象列表
     */
    @PostMapping(value = "/list")
    @Operation(summary = "查询所有")
    public ResultBean<List<LikeVO>> list(@RequestBody LikeQuery likeQuery) {
        //处理格式转换
        Like like = LikeConverter.INSTANT.queryToEntity(likeQuery);
        //执行分页查询
        List<Like> listResult = likeService.list(new QueryWrapper<>(like));
        return ResultBean.success(BeanCopyUtils.coverList(listResult, LikeVO.class));
    }

    /**
     * 分页查询所有数据
     *
     * @param pageQuery 分页对象
     * @param likeQuery 查询实体
     * @return 分页对象
     */
    @PostMapping(value = "/page")
    @Operation(summary = "分页查询")
    public ResultBean<PagerBean<LikeVO>> page(PageQuery pageQuery, LikeQuery likeQuery) {
        //处理分页条件
        Page<Like> page = new Page<>(pageQuery.getPageNum(), pageQuery.getPageSize());
        //处理格式转换
        Like like = LikeConverter.INSTANT.queryToEntity(likeQuery);
        //执行分页查询
        Page<Like> pageResult = likeService.page(page, new QueryWrapper<>(like));
        PagerBean<LikeVO> pageBean = new PagerBean<>(pageResult.getTotal(), pageResult.getCurrent(),
                pageResult.getSize(), BeanCopyUtils.coverList(pageResult.getRecords(), LikeVO.class));
        return ResultBean.success(pageBean);
    }

    /**
     * 新增数据
     *
     * @param likeDTO 实体对象
     * @return 新增结果
     */
    @PostMapping("/add")
    @Operation(summary = "新增数据")
    public ResultBean<Boolean> insert(@RequestBody @Validated LikePostDTO likeDTO) {
        //处理格式转换
        Like like = LikeConverter.INSTANT.postDtoToEntity(likeDTO);
        //执行数据保存
        return ResultBean.success(likeService.save(like));
    }

    /**
     * 修改数据
     *
     * @param likeDTO 实体对象
     * @return 修改结果
     */
    @PutMapping("/update")
    @Operation(summary = "修改数据")
    public ResultBean<Boolean> update(@RequestBody @Validated LikePutDTO likeDTO) {
        //处理格式转换
        Like like = LikeConverter.INSTANT.putDtoToEntity(likeDTO);
        //执行数据更新
        return ResultBean.success(likeService.updateById(like));
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
        return ResultBean.success(likeService.removeByIds(ids));
    }

}

