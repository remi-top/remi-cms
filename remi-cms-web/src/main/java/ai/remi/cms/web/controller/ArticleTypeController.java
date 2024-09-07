package ai.remi.cms.web.controller;


import ai.remi.cms.domain.converter.ArticleTypeConverter;
import ai.remi.cms.domain.dto.post.ArticleTypePostDTO;
import ai.remi.cms.domain.dto.put.ArticleTypePutDTO;
import ai.remi.cms.domain.entity.ArticleType;
import ai.remi.cms.domain.query.ArticleTypeQuery;
import ai.remi.cms.domain.vo.ArticleTypeVO;
import ai.remi.cms.server.service.ArticleTypeService;
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
 * @desc 文章分类(ArticleType)控制层
 */
@Validated
@RestController
@ApiSort(value = 1)
@Tag(name = "文章分类")
@RequestMapping("articleType")
public class ArticleTypeController {
    /**
     * 服务对象
     */
    @Resource
    private ArticleTypeService articleTypeService;


    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    @Operation(summary = "查询单条")
    public ResultBean<ArticleTypeVO> get(@PathVariable @Validated @NotBlank(message = "ID不能为空") String id) {
        ArticleType articleType = articleTypeService.getById(id);
        //处理格式转换
        ArticleTypeVO articleTypeVO = ArticleTypeConverter.INSTANT.entityToVO(articleType);
        return ResultBean.success(articleTypeVO);
    }

    /**
     * 通过实体不为空的属性作为筛选条件查询对象列表
     *
     * @param articleTypeQuery 实例对象
     * @return 对象列表
     */
    @PostMapping(value = "/list")
    @Operation(summary = "查询所有")
    public ResultBean<List<ArticleTypeVO>> list(@RequestBody ArticleTypeQuery articleTypeQuery) {
        //处理格式转换
        ArticleType articleType = ArticleTypeConverter.INSTANT.queryToEntity(articleTypeQuery);
        //执行分页查询
        List<ArticleType> listResult = articleTypeService.list(new QueryWrapper<>(articleType));
        return ResultBean.success(BeanCopyUtils.coverList(listResult, ArticleTypeVO.class));
    }

    /**
     * 分页查询所有数据
     *
     * @param pageQuery        分页对象
     * @param articleTypeQuery 查询实体
     * @return 分页对象
     */
    @PostMapping(value = "/page")
    @Operation(summary = "分页查询")
    public ResultBean<PagerBean<ArticleTypeVO>> page(PageQuery pageQuery, ArticleTypeQuery articleTypeQuery) {
        //处理分页条件
        Page<ArticleType> page = new Page<>(pageQuery.getPageNum(), pageQuery.getPageSize());
        //处理格式转换
        ArticleType articleType = ArticleTypeConverter.INSTANT.queryToEntity(articleTypeQuery);
        //执行分页查询
        Page<ArticleType> pageResult = articleTypeService.page(page, new QueryWrapper<>(articleType));
        PagerBean<ArticleTypeVO> pageBean = new PagerBean<>(pageResult.getTotal(), pageResult.getCurrent(),
                pageResult.getSize(), BeanCopyUtils.coverList(pageResult.getRecords(), ArticleTypeVO.class));
        return ResultBean.success(pageBean);
    }

    /**
     * 新增数据
     *
     * @param articleTypeDTO 实体对象
     * @return 新增结果
     */
    @PostMapping("/add")
    @Operation(summary = "新增数据")
    public ResultBean<Boolean> insert(@RequestBody @Validated ArticleTypePostDTO articleTypeDTO) {
        //处理格式转换
        ArticleType articleType = ArticleTypeConverter.INSTANT.postDtoToEntity(articleTypeDTO);
        //执行数据保存
        return ResultBean.success(articleTypeService.save(articleType));
    }

    /**
     * 修改数据
     *
     * @param articleTypeDTO 实体对象
     * @return 修改结果
     */
    @PutMapping("/update")
    @Operation(summary = "修改数据")
    public ResultBean<Boolean> update(@RequestBody @Validated ArticleTypePutDTO articleTypeDTO) {
        //处理格式转换
        ArticleType articleType = ArticleTypeConverter.INSTANT.putDtoToEntity(articleTypeDTO);
        //执行数据更新
        return ResultBean.success(articleTypeService.updateById(articleType));
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
        return ResultBean.success(articleTypeService.removeByIds(ids));
    }

}

