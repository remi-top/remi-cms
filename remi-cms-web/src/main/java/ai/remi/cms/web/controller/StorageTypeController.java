package ai.remi.cms.web.controller;


import ai.remi.cms.domain.converter.StorageTypeConverter;
import ai.remi.cms.domain.dto.post.StorageTypePostDTO;
import ai.remi.cms.domain.dto.put.StorageTypePutDTO;
import ai.remi.cms.domain.entity.StorageType;
import ai.remi.cms.domain.query.StorageTypeQuery;
import ai.remi.cms.domain.vo.StorageTypeVO;
import ai.remi.cms.server.service.StorageTypeService;
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
 * @desc 资源分类(StorageType)控制层
 */
@Validated
@RestController
@ApiSort(value = 1)
@Tag(name = "资源分类")
@RequestMapping("storageType")
public class StorageTypeController {
    /**
     * 服务对象
     */
    @Resource
    private StorageTypeService storageTypeService;


    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    @Operation(summary = "查询单条")
    public ResultBean<StorageTypeVO> get(@PathVariable @Validated @NotBlank(message = "ID不能为空") String id) {
        StorageType storageType = storageTypeService.getById(id);
        //处理格式转换
        StorageTypeVO storageTypeVO = StorageTypeConverter.INSTANT.entityToVO(storageType);
        return ResultBean.success(storageTypeVO);
    }

    /**
     * 通过实体不为空的属性作为筛选条件查询对象列表
     *
     * @param storageTypeQuery 实例对象
     * @return 对象列表
     */
    @PostMapping(value = "/list")
    @Operation(summary = "查询所有")
    public ResultBean<List<StorageTypeVO>> list(@RequestBody StorageTypeQuery storageTypeQuery) {
        //处理格式转换
        StorageType storageType = StorageTypeConverter.INSTANT.queryToEntity(storageTypeQuery);
        //执行分页查询
        List<StorageType> listResult = storageTypeService.list(new QueryWrapper<>(storageType));
        return ResultBean.success(BeanCopyUtils.coverList(listResult, StorageTypeVO.class));
    }

    /**
     * 分页查询所有数据
     *
     * @param pageQuery        分页对象
     * @param storageTypeQuery 查询实体
     * @return 分页对象
     */
    @PostMapping(value = "/page")
    @Operation(summary = "分页查询")
    public ResultBean<PagerBean<StorageTypeVO>> page(PageQuery pageQuery, StorageTypeQuery storageTypeQuery) {
        //处理分页条件
        Page<StorageType> page = new Page<>(pageQuery.getPageNum(), pageQuery.getPageSize());
        //处理格式转换
        StorageType storageType = StorageTypeConverter.INSTANT.queryToEntity(storageTypeQuery);
        //执行分页查询
        Page<StorageType> pageResult = storageTypeService.page(page, new QueryWrapper<>(storageType));
        PagerBean<StorageTypeVO> pageBean = new PagerBean<>(pageResult.getTotal(), pageResult.getCurrent(),
                pageResult.getSize(), BeanCopyUtils.coverList(pageResult.getRecords(), StorageTypeVO.class));
        return ResultBean.success(pageBean);
    }

    /**
     * 新增数据
     *
     * @param storageTypeDTO 实体对象
     * @return 新增结果
     */
    @PostMapping("/add")
    @Operation(summary = "新增数据")
    public ResultBean<Boolean> insert(@RequestBody @Validated StorageTypePostDTO storageTypeDTO) {
        //处理格式转换
        StorageType storageType = StorageTypeConverter.INSTANT.postDtoToEntity(storageTypeDTO);
        //执行数据保存
        return ResultBean.success(storageTypeService.save(storageType));
    }

    /**
     * 修改数据
     *
     * @param storageTypeDTO 实体对象
     * @return 修改结果
     */
    @PutMapping("/update")
    @Operation(summary = "修改数据")
    public ResultBean<Boolean> update(@RequestBody @Validated StorageTypePutDTO storageTypeDTO) {
        //处理格式转换
        StorageType storageType = StorageTypeConverter.INSTANT.putDtoToEntity(storageTypeDTO);
        //执行数据更新
        return ResultBean.success(storageTypeService.updateById(storageType));
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
        return ResultBean.success(storageTypeService.removeByIds(ids));
    }

}

