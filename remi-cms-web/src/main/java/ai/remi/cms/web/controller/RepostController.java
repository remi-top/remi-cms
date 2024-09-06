package ai.remi.cms.web.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import ai.remi.cms.domain.converter.RepostConverter;
import ai.remi.cms.domain.dto.post.RepostPostDTO;
import ai.remi.cms.domain.dto.put.RepostPutDTO;
import ai.remi.cms.domain.entity.Repost;
import ai.remi.cms.domain.query.RepostQuery;
import ai.remi.cms.domain.vo.RepostVO;
import ai.remi.cms.server.service.RepostService;
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
 * @desc 转发记录(Repost)控制层
 */
@Validated
@RestController
@ApiSort(value = 1)
@Tag(name = "转发记录")
@RequestMapping("repost")
public class RepostController {
    /**
     * 服务对象
     */
    @Resource
    private RepostService repostService;


    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    @Operation(summary = "查询单条")
    public ResultBean<RepostVO> get(@PathVariable @Validated @NotBlank(message = "ID不能为空") String id) {
        Repost repost = repostService.getById(id);
        //处理格式转换
        RepostVO repostVO = RepostConverter.INSTANT.entityToVO(repost);
        return ResultBean.success(repostVO);
    }

    /**
     * 通过实体不为空的属性作为筛选条件查询对象列表
     *
     * @param repostQuery 实例对象
     * @return 对象列表
     */
    @PostMapping(value = "/list")
    @Operation(summary = "查询所有")
    public ResultBean<List<RepostVO>> list(@RequestBody RepostQuery repostQuery) {
        //处理格式转换
        Repost repost = RepostConverter.INSTANT.queryToEntity(repostQuery);
        //执行分页查询
        List<Repost> listResult = repostService.list(new QueryWrapper<>(repost));
        return ResultBean.success(BeanCopyUtils.coverList(listResult, RepostVO.class));
    }

    /**
     * 分页查询所有数据
     *
     * @param pageQuery   分页对象
     * @param repostQuery 查询实体
     * @return 分页对象
     */
    @PostMapping(value = "/page")
    @Operation(summary = "分页查询")
    public ResultBean<PagerBean<RepostVO>> page(PageQuery pageQuery, RepostQuery repostQuery) {
        //处理分页条件
        Page<Repost> page = new Page<>(pageQuery.getPageNum(), pageQuery.getPageSize());
        //处理格式转换
        Repost repost = RepostConverter.INSTANT.queryToEntity(repostQuery);
        //执行分页查询
        Page<Repost> pageResult = repostService.page(page, new QueryWrapper<>(repost));
        PagerBean<RepostVO> pageBean = new PagerBean<>(pageResult.getTotal(), pageResult.getCurrent(),
                pageResult.getSize(), BeanCopyUtils.coverList(pageResult.getRecords(), RepostVO.class));
        return ResultBean.success(pageBean);
    }

    /**
     * 新增数据
     *
     * @param repostDTO 实体对象
     * @return 新增结果
     */
    @PostMapping("/add")
    @Operation(summary = "新增数据")
    public ResultBean<Boolean> insert(@RequestBody @Validated RepostPostDTO repostDTO) {
        //处理格式转换
        Repost repost = RepostConverter.INSTANT.postDtoToEntity(repostDTO);
        //执行数据保存
        return ResultBean.success(repostService.save(repost));
    }

    /**
     * 修改数据
     *
     * @param repostDTO 实体对象
     * @return 修改结果
     */
    @PutMapping("/update")
    @Operation(summary = "修改数据")
    public ResultBean<Boolean> update(@RequestBody @Validated RepostPutDTO repostDTO) {
        //处理格式转换
        Repost repost = RepostConverter.INSTANT.putDtoToEntity(repostDTO);
        //执行数据更新
        return ResultBean.success(repostService.updateById(repost));
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
        return ResultBean.success(repostService.removeByIds(ids));
    }

}

