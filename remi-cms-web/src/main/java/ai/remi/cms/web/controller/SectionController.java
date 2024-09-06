package ai.remi.cms.web.controller;

import ai.remi.cms.domain.converter.SectionConverter;
import ai.remi.cms.domain.dto.post.SectionPostDTO;
import ai.remi.cms.domain.dto.put.SectionPutDTO;
import ai.remi.cms.domain.entity.Section;
import ai.remi.cms.domain.query.SectionQuery;
import ai.remi.cms.domain.tree.SectionTree;
import ai.remi.cms.domain.vo.SectionVO;
import ai.remi.cms.infra.mapper.SectionMapper;
import ai.remi.cms.server.service.SectionService;
import ai.remi.comm.core.result.ResultBean;
import ai.remi.comm.domain.tree.TreeBuild;
import ai.remi.comm.log.annotation.LogRecord;
import ai.remi.comm.log.enums.BusinessType;
import ai.remi.comm.util.bean.BeanCopyUtils;
import ai.remi.comm.util.collection.CollectionUtils;
import ai.remi.comm.util.string.StringUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
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
 * @desc 栏目表(Section)控制层
 */
@Validated
@RestController
@Tag(name = "栏目管理")
@RequestMapping("section")
public class SectionController {

    @Resource
    private SectionService sectionService;

    @Resource
    private SectionMapper sectionMapper;


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
    @PostMapping(value = "/tree")
    @Operation(summary = "查询树结构")
    public ResultBean<List<SectionTree>> tree(@RequestBody SectionQuery sectionQuery) {
        Section section = SectionConverter.INSTANT.queryToEntity(sectionQuery);
        List<Section> listResult = sectionService.getBaseMapper().selectList(Wrappers.<Section>lambdaQuery()
                .like(StringUtils.isNotEmpty(section.getSectionName()), Section::getSectionName, section.getSectionName())
                .last("ORDER BY ISNULL( sort ) ASC,sort ASC"));
        // 原查询结果转换树形结构
        List<SectionTree> sectionTrees = BeanCopyUtils.coverList(listResult, SectionTree.class);
        if (CollectionUtils.isNotEmpty(sectionTrees)) {
            String rootId = "0";
            // 创建树形结构并返回
            TreeBuild treeBuild = new TreeBuild(rootId, sectionTrees);
            List buildTree = treeBuild.buildTree();
            return ResultBean.success(buildTree);
        }
        return ResultBean.success(sectionTrees);
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
    @LogRecord(content = "删除栏目数据", businessType = BusinessType.DELETE)
    public ResultBean<Boolean> delete(@RequestParam("ids") List<String> ids) {
        return ResultBean.success(sectionService.removeByIds(ids));
    }

}

