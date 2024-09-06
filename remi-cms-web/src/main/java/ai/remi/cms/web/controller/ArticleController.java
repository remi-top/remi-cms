package ai.remi.cms.web.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import ai.remi.cms.domain.converter.ArticleConverter;
import ai.remi.cms.domain.dto.post.ArticlePostDTO;
import ai.remi.cms.domain.dto.put.ArticlePutDTO;
import ai.remi.cms.domain.entity.Article;
import ai.remi.cms.domain.query.ArticleQuery;
import ai.remi.cms.domain.vo.ArticleVO;
import ai.remi.cms.server.service.ArticleService;
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
 * @desc 文章内容(Article)控制层
 */
@Validated
@RestController
@ApiSort(value = 1)
@Tag(name = "文章内容")
@RequestMapping("article")
public class ArticleController {
    /**
     * 服务对象
     */
    @Resource
    private ArticleService articleService;


    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    @Operation(summary = "查询单条")
    public ResultBean<ArticleVO> get(@PathVariable @Validated @NotBlank(message = "ID不能为空") String id) {
        Article article = articleService.getById(id);
        //处理格式转换
        ArticleVO articleVO = ArticleConverter.INSTANT.entityToVO(article);
        return ResultBean.success(articleVO);
    }

    /**
     * 通过实体不为空的属性作为筛选条件查询对象列表
     *
     * @param articleQuery 实例对象
     * @return 对象列表
     */
    @PostMapping(value = "/list")
    @Operation(summary = "查询所有")
    public ResultBean<List<ArticleVO>> list(@RequestBody ArticleQuery articleQuery) {
        //处理格式转换
        Article article = ArticleConverter.INSTANT.queryToEntity(articleQuery);
        //执行分页查询
        List<Article> listResult = articleService.list(new QueryWrapper<>(article));
        return ResultBean.success(BeanCopyUtils.coverList(listResult, ArticleVO.class));
    }

    /**
     * 分页查询所有数据
     *
     * @param pageQuery    分页对象
     * @param articleQuery 查询实体
     * @return 分页对象
     */
    @PostMapping(value = "/page")
    @Operation(summary = "分页查询")
    public ResultBean<PagerBean<ArticleVO>> page(PageQuery pageQuery, ArticleQuery articleQuery) {
        //处理分页条件
        Page<Article> page = new Page<>(pageQuery.getPageNum(), pageQuery.getPageSize());
        //处理格式转换
        Article article = ArticleConverter.INSTANT.queryToEntity(articleQuery);
        //执行分页查询
        Page<Article> pageResult = articleService.page(page, new QueryWrapper<>(article));
        PagerBean<ArticleVO> pageBean = new PagerBean<>(pageResult.getTotal(), pageResult.getCurrent(),
                pageResult.getSize(), BeanCopyUtils.coverList(pageResult.getRecords(), ArticleVO.class));
        return ResultBean.success(pageBean);
    }

    /**
     * 新增数据
     *
     * @param articleDTO 实体对象
     * @return 新增结果
     */
    @PostMapping("/add")
    @Operation(summary = "新增数据")
    public ResultBean<Boolean> insert(@RequestBody @Validated ArticlePostDTO articleDTO) {
        //处理格式转换
        Article article = ArticleConverter.INSTANT.postDtoToEntity(articleDTO);
        //执行数据保存
        return ResultBean.success(articleService.save(article));
    }

    /**
     * 修改数据
     *
     * @param articleDTO 实体对象
     * @return 修改结果
     */
    @PutMapping("/update")
    @Operation(summary = "修改数据")
    public ResultBean<Boolean> update(@RequestBody @Validated ArticlePutDTO articleDTO) {
        //处理格式转换
        Article article = ArticleConverter.INSTANT.putDtoToEntity(articleDTO);
        //执行数据更新
        return ResultBean.success(articleService.updateById(article));
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
        return ResultBean.success(articleService.removeByIds(ids));
    }

}

