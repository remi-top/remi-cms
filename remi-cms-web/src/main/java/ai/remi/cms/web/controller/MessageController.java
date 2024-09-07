package ai.remi.cms.web.controller;


import ai.remi.cms.domain.converter.MessageConverter;
import ai.remi.cms.domain.dto.post.MessagePostDTO;
import ai.remi.cms.domain.dto.put.MessagePutDTO;
import ai.remi.cms.domain.entity.Message;
import ai.remi.cms.domain.query.MessageQuery;
import ai.remi.cms.domain.vo.MessageVO;
import ai.remi.cms.server.service.MessageService;
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
 * @desc 留言记录(Message)控制层
 */
@Validated
@RestController
@ApiSort(value = 1)
@Tag(name = "留言记录")
@RequestMapping("message")
public class MessageController {
    /**
     * 服务对象
     */
    @Resource
    private MessageService messageService;


    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    @Operation(summary = "查询单条")
    public ResultBean<MessageVO> get(@PathVariable @Validated @NotBlank(message = "ID不能为空") String id) {
        Message message = messageService.getById(id);
        //处理格式转换
        MessageVO messageVO = MessageConverter.INSTANT.entityToVO(message);
        return ResultBean.success(messageVO);
    }

    /**
     * 通过实体不为空的属性作为筛选条件查询对象列表
     *
     * @param messageQuery 实例对象
     * @return 对象列表
     */
    @PostMapping(value = "/list")
    @Operation(summary = "查询所有")
    public ResultBean<List<MessageVO>> list(@RequestBody MessageQuery messageQuery) {
        //处理格式转换
        Message message = MessageConverter.INSTANT.queryToEntity(messageQuery);
        //执行分页查询
        List<Message> listResult = messageService.list(new QueryWrapper<>(message));
        return ResultBean.success(BeanCopyUtils.coverList(listResult, MessageVO.class));
    }

    /**
     * 分页查询所有数据
     *
     * @param pageQuery    分页对象
     * @param messageQuery 查询实体
     * @return 分页对象
     */
    @PostMapping(value = "/page")
    @Operation(summary = "分页查询")
    public ResultBean<PagerBean<MessageVO>> page(PageQuery pageQuery, MessageQuery messageQuery) {
        //处理分页条件
        Page<Message> page = new Page<>(pageQuery.getPageNum(), pageQuery.getPageSize());
        //处理格式转换
        Message message = MessageConverter.INSTANT.queryToEntity(messageQuery);
        //执行分页查询
        Page<Message> pageResult = messageService.page(page, new QueryWrapper<>(message));
        PagerBean<MessageVO> pageBean = new PagerBean<>(pageResult.getTotal(), pageResult.getCurrent(),
                pageResult.getSize(), BeanCopyUtils.coverList(pageResult.getRecords(), MessageVO.class));
        return ResultBean.success(pageBean);
    }

    /**
     * 新增数据
     *
     * @param messageDTO 实体对象
     * @return 新增结果
     */
    @PostMapping("/add")
    @Operation(summary = "新增数据")
    public ResultBean<Boolean> insert(@RequestBody @Validated MessagePostDTO messageDTO) {
        //处理格式转换
        Message message = MessageConverter.INSTANT.postDtoToEntity(messageDTO);
        //执行数据保存
        return ResultBean.success(messageService.save(message));
    }

    /**
     * 修改数据
     *
     * @param messageDTO 实体对象
     * @return 修改结果
     */
    @PutMapping("/update")
    @Operation(summary = "修改数据")
    public ResultBean<Boolean> update(@RequestBody @Validated MessagePutDTO messageDTO) {
        //处理格式转换
        Message message = MessageConverter.INSTANT.putDtoToEntity(messageDTO);
        //执行数据更新
        return ResultBean.success(messageService.updateById(message));
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
        return ResultBean.success(messageService.removeByIds(ids));
    }

}

