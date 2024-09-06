package ai.remi.cms.web.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import ai.remi.cms.domain.converter.LeaveConverter;
import ai.remi.cms.domain.dto.post.LeavePostDTO;
import ai.remi.cms.domain.dto.put.LeavePutDTO;
import ai.remi.cms.domain.entity.Leave;
import ai.remi.cms.domain.query.LeaveQuery;
import ai.remi.cms.domain.vo.LeaveVO;
import ai.remi.cms.server.service.LeaveService;
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
 * @desc 评论记录(Leave)控制层
 */
@Validated
@RestController
@ApiSort(value = 1)
@Tag(name = "评论记录")
@RequestMapping("leave")
public class LeaveController {
    /**
     * 服务对象
     */
    @Resource
    private LeaveService leaveService;


    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    @Operation(summary = "查询单条")
    public ResultBean<LeaveVO> get(@PathVariable @Validated @NotBlank(message = "ID不能为空") String id) {
        Leave leave = leaveService.getById(id);
        //处理格式转换
        LeaveVO leaveVO = LeaveConverter.INSTANT.entityToVO(leave);
        return ResultBean.success(leaveVO);
    }

    /**
     * 通过实体不为空的属性作为筛选条件查询对象列表
     *
     * @param leaveQuery 实例对象
     * @return 对象列表
     */
    @PostMapping(value = "/list")
    @Operation(summary = "查询所有")
    public ResultBean<List<LeaveVO>> list(@RequestBody LeaveQuery leaveQuery) {
        //处理格式转换
        Leave leave = LeaveConverter.INSTANT.queryToEntity(leaveQuery);
        //执行分页查询
        List<Leave> listResult = leaveService.list(new QueryWrapper<>(leave));
        return ResultBean.success(BeanCopyUtils.coverList(listResult, LeaveVO.class));
    }

    /**
     * 分页查询所有数据
     *
     * @param pageQuery  分页对象
     * @param leaveQuery 查询实体
     * @return 分页对象
     */
    @PostMapping(value = "/page")
    @Operation(summary = "分页查询")
    public ResultBean<PagerBean<LeaveVO>> page(PageQuery pageQuery, LeaveQuery leaveQuery) {
        //处理分页条件
        Page<Leave> page = new Page<>(pageQuery.getPageNum(), pageQuery.getPageSize());
        //处理格式转换
        Leave leave = LeaveConverter.INSTANT.queryToEntity(leaveQuery);
        //执行分页查询
        Page<Leave> pageResult = leaveService.page(page, new QueryWrapper<>(leave));
        PagerBean<LeaveVO> pageBean = new PagerBean<>(pageResult.getTotal(), pageResult.getCurrent(),
                pageResult.getSize(), BeanCopyUtils.coverList(pageResult.getRecords(), LeaveVO.class));
        return ResultBean.success(pageBean);
    }

    /**
     * 新增数据
     *
     * @param leaveDTO 实体对象
     * @return 新增结果
     */
    @PostMapping("/add")
    @Operation(summary = "新增数据")
    public ResultBean<Boolean> insert(@RequestBody @Validated LeavePostDTO leaveDTO) {
        //处理格式转换
        Leave leave = LeaveConverter.INSTANT.postDtoToEntity(leaveDTO);
        //执行数据保存
        return ResultBean.success(leaveService.save(leave));
    }

    /**
     * 修改数据
     *
     * @param leaveDTO 实体对象
     * @return 修改结果
     */
    @PutMapping("/update")
    @Operation(summary = "修改数据")
    public ResultBean<Boolean> update(@RequestBody @Validated LeavePutDTO leaveDTO) {
        //处理格式转换
        Leave leave = LeaveConverter.INSTANT.putDtoToEntity(leaveDTO);
        //执行数据更新
        return ResultBean.success(leaveService.updateById(leave));
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
        return ResultBean.success(leaveService.removeByIds(ids));
    }

}

