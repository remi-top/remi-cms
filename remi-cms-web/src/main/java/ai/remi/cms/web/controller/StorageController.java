package ai.remi.cms.web.controller;


import ai.remi.cms.domain.converter.StorageConverter;
import ai.remi.cms.domain.dto.post.StoragePostDTO;
import ai.remi.cms.domain.dto.put.StoragePutDTO;
import ai.remi.cms.domain.entity.Storage;
import ai.remi.cms.domain.query.StorageQuery;
import ai.remi.cms.domain.vo.StorageVO;
import ai.remi.cms.server.service.StorageService;
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
 * @desc 文件资源(Storage)控制层
 */
@Validated
@RestController
@ApiSort(value = 1)
@Tag(name = "文件资源")
@RequestMapping("storage")
public class StorageController {
    /**
     * 服务对象
     */
    @Resource
    private StorageService storageService;


    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    @Operation(summary = "查询单条")
    public ResultBean<StorageVO> get(@PathVariable @Validated @NotBlank(message = "ID不能为空") String id) {
        Storage storage = storageService.getById(id);
        //处理格式转换
        StorageVO storageVO = StorageConverter.INSTANT.entityToVO(storage);
        return ResultBean.success(storageVO);
    }

    /**
     * 通过实体不为空的属性作为筛选条件查询对象列表
     *
     * @param storageQuery 实例对象
     * @return 对象列表
     */
    @PostMapping(value = "/list")
    @Operation(summary = "查询所有")
    public ResultBean<List<StorageVO>> list(@RequestBody StorageQuery storageQuery) {
        //处理格式转换
        Storage storage = StorageConverter.INSTANT.queryToEntity(storageQuery);
        //执行分页查询
        List<Storage> listResult = storageService.list(new QueryWrapper<>(storage));
        return ResultBean.success(BeanCopyUtils.coverList(listResult, StorageVO.class));
    }

    /**
     * 分页查询所有数据
     *
     * @param pageQuery    分页对象
     * @param storageQuery 查询实体
     * @return 分页对象
     */
    @PostMapping(value = "/page")
    @Operation(summary = "分页查询")
    public ResultBean<PagerBean<StorageVO>> page(PageQuery pageQuery, StorageQuery storageQuery) {
        //处理分页条件
        Page<Storage> page = new Page<>(pageQuery.getPageNum(), pageQuery.getPageSize());
        //处理格式转换
        Storage storage = StorageConverter.INSTANT.queryToEntity(storageQuery);
        //执行分页查询
        Page<Storage> pageResult = storageService.page(page, new QueryWrapper<>(storage));
        PagerBean<StorageVO> pageBean = new PagerBean<>(pageResult.getTotal(), pageResult.getCurrent(),
                pageResult.getSize(), BeanCopyUtils.coverList(pageResult.getRecords(), StorageVO.class));
        return ResultBean.success(pageBean);
    }

    /**
     * 新增数据
     *
     * @param storageDTO 实体对象
     * @return 新增结果
     */
    @PostMapping("/add")
    @Operation(summary = "新增数据")
    public ResultBean<Boolean> insert(@RequestBody @Validated StoragePostDTO storageDTO) {
        //处理格式转换
        Storage storage = StorageConverter.INSTANT.postDtoToEntity(storageDTO);
        //执行数据保存
        return ResultBean.success(storageService.save(storage));
    }

    /**
     * 修改数据
     *
     * @param storageDTO 实体对象
     * @return 修改结果
     */
    @PutMapping("/update")
    @Operation(summary = "修改数据")
    public ResultBean<Boolean> update(@RequestBody @Validated StoragePutDTO storageDTO) {
        //处理格式转换
        Storage storage = StorageConverter.INSTANT.putDtoToEntity(storageDTO);
        //执行数据更新
        return ResultBean.success(storageService.updateById(storage));
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
        return ResultBean.success(storageService.removeByIds(ids));
    }

}

