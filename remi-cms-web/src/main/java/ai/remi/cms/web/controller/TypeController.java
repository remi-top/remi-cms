package ai.remi.cms.web.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import ai.remi.cms.domain.converter.TypeConverter;
import ai.remi.cms.domain.dto.post.TypePostDTO;
import ai.remi.cms.domain.dto.put.TypePutDTO;
import ai.remi.cms.domain.entity.Type;
import ai.remi.cms.domain.query.TypeQuery;
import ai.remi.cms.domain.vo.TypeVO;
import ai.remi.cms.server.service.TypeService;
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
 * @desc 分类管理(Type)控制层
 */
@Validated
@RestController
@ApiSort(value = 1)
@Tag(name = "分类管理")
@RequestMapping("type")
public class TypeController {
    /**
     * 服务对象
     */
    @Resource
    private TypeService typeService;


    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    @Operation(summary = "查询单条")
    public ResultBean<TypeVO> get(@PathVariable @Validated @NotBlank(message = "ID不能为空") String id) {
        Type type = typeService.getById(id);
        //处理格式转换
        TypeVO typeVO = TypeConverter.INSTANT.entityToVO(type);
        return ResultBean.success(typeVO);
    }

    /**
     * 通过实体不为空的属性作为筛选条件查询对象列表
     *
     * @param typeQuery 实例对象
     * @return 对象列表
     */
    @PostMapping(value = "/list")
    @Operation(summary = "查询所有")
    public ResultBean<List<TypeVO>> list(@RequestBody TypeQuery typeQuery) {
        //处理格式转换
        Type type = TypeConverter.INSTANT.queryToEntity(typeQuery);
        //执行分页查询
        List<Type> listResult = typeService.list(new QueryWrapper<>(type));
        return ResultBean.success(BeanCopyUtils.coverList(listResult, TypeVO.class));
    }

    /**
     * 分页查询所有数据
     *
     * @param pageQuery 分页对象
     * @param typeQuery 查询实体
     * @return 分页对象
     */
    @PostMapping(value = "/page")
    @Operation(summary = "分页查询")
    public ResultBean<PagerBean<TypeVO>> page(PageQuery pageQuery, TypeQuery typeQuery) {
        //处理分页条件
        Page<Type> page = new Page<>(pageQuery.getPageNum(), pageQuery.getPageSize());
        //处理格式转换
        Type type = TypeConverter.INSTANT.queryToEntity(typeQuery);
        //执行分页查询
        Page<Type> pageResult = typeService.page(page, new QueryWrapper<>(type));
        PagerBean<TypeVO> pageBean = new PagerBean<>(pageResult.getTotal(), pageResult.getCurrent(),
                pageResult.getSize(), BeanCopyUtils.coverList(pageResult.getRecords(), TypeVO.class));
        return ResultBean.success(pageBean);
    }

    /**
     * 新增数据
     *
     * @param typeDTO 实体对象
     * @return 新增结果
     */
    @PostMapping("/add")
    @Operation(summary = "新增数据")
    public ResultBean<Boolean> insert(@RequestBody @Validated TypePostDTO typeDTO) {
        //处理格式转换
        Type type = TypeConverter.INSTANT.postDtoToEntity(typeDTO);
        //执行数据保存
        return ResultBean.success(typeService.save(type));
    }

    /**
     * 修改数据
     *
     * @param typeDTO 实体对象
     * @return 修改结果
     */
    @PutMapping("/update")
    @Operation(summary = "修改数据")
    public ResultBean<Boolean> update(@RequestBody @Validated TypePutDTO typeDTO) {
        //处理格式转换
        Type type = TypeConverter.INSTANT.putDtoToEntity(typeDTO);
        //执行数据更新
        return ResultBean.success(typeService.updateById(type));
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
        return ResultBean.success(typeService.removeByIds(ids));
    }

}

