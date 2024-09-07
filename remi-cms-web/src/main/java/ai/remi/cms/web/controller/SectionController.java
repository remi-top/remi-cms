package ai.remi.cms.web.controller;


import ai.remi.cms.domain.converter.SectionConverter;
import ai.remi.cms.domain.dto.post.SectionPostDTO;
import ai.remi.cms.domain.dto.put.SectionPutDTO;
import ai.remi.cms.domain.entity.Section;
import ai.remi.cms.domain.query.SectionQuery;
import ai.remi.cms.domain.vo.SectionVO;
import ai.remi.cms.server.service.SectionService;
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
 * @desc 栏目管理(Section)控制层
 */
@Validated
@RestController
@ApiSort(value = 1)
@Tag(name = "栏目管理")
@RequestMapping("section")
public class SectionController {
    /**
     * 服务对象
     */
    @Resource
    private SectionService sectionService;


    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    @Operation(summary = "查询单条")
    public ResultBean<SectionVO> get(@PathVariable @Validated @NotBlank(message = "ID不能为空") String id) {
        Section section = sectionService.getById(id);
        //处理格式转换
        SectionVO sectionVO = SectionConverter.INSTANT.entityToVO(section);
        return ResultBean.success(sectionVO);
    }

    /**
     * 通过实体不为空的属性作为筛选条件查询对象列表
     *
     * @param sectionQuery 实例对象
     * @return 对象列表
     */
    @PostMapping(value = "/list")
    @Operation(summary = "查询所有")
    public ResultBean<List<SectionVO>> list(@RequestBody SectionQuery sectionQuery) {
        //处理格式转换
        Section section = SectionConverter.INSTANT.queryToEntity(sectionQuery);
        //执行分页查询
        List<Section> listResult = sectionService.list(new QueryWrapper<>(section));
        return ResultBean.success(BeanCopyUtils.coverList(listResult, SectionVO.class));
    }

    /**
     * 分页查询所有数据
     *
     * @param pageQuery    分页对象
     * @param sectionQuery 查询实体
     * @return 分页对象
     */
    @PostMapping(value = "/page")
    @Operation(summary = "分页查询")
    public ResultBean<PagerBean<SectionVO>> page(PageQuery pageQuery, SectionQuery sectionQuery) {
        //处理分页条件
        Page<Section> page = new Page<>(pageQuery.getPageNum(), pageQuery.getPageSize());
        //处理格式转换
        Section section = SectionConverter.INSTANT.queryToEntity(sectionQuery);
        //执行分页查询
        Page<Section> pageResult = sectionService.page(page, new QueryWrapper<>(section));
        PagerBean<SectionVO> pageBean = new PagerBean<>(pageResult.getTotal(), pageResult.getCurrent(),
                pageResult.getSize(), BeanCopyUtils.coverList(pageResult.getRecords(), SectionVO.class));
        return ResultBean.success(pageBean);
    }

    /**
     * 新增数据
     *
     * @param sectionDTO 实体对象
     * @return 新增结果
     */
    @PostMapping("/add")
    @Operation(summary = "新增数据")
    public ResultBean<Boolean> insert(@RequestBody @Validated SectionPostDTO sectionDTO) {
        //处理格式转换
        Section section = SectionConverter.INSTANT.postDtoToEntity(sectionDTO);
        //执行数据保存
        return ResultBean.success(sectionService.save(section));
    }

    /**
     * 修改数据
     *
     * @param sectionDTO 实体对象
     * @return 修改结果
     */
    @PutMapping("/update")
    @Operation(summary = "修改数据")
    public ResultBean<Boolean> update(@RequestBody @Validated SectionPutDTO sectionDTO) {
        //处理格式转换
        Section section = SectionConverter.INSTANT.putDtoToEntity(sectionDTO);
        //执行数据更新
        return ResultBean.success(sectionService.updateById(section));
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
        return ResultBean.success(sectionService.removeByIds(ids));
    }

}

