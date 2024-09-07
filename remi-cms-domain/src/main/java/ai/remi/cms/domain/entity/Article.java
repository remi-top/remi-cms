package ai.remi.cms.domain.entity;

import ai.remi.comm.domain.entity.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

/**
 * @author DianJiu
 * @email dianjiuxyz@gmail.com
 * @desc 文章内容 ArticleDTO对象
 */
@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@TableName("cms_article")
public class Article extends BaseEntity {


    /**
     * 分类ID
     */
    private String typeId;

    /**
     * 分类编码
     */
    private String typeCode;

    /**
     * 文章类型（1原创 2转载 3翻译）
     */
    private Integer articleType;

    /**
     * 文章标题
     */
    private String articleTitle;

    /**
     * 文章英文标题
     */
    private String articleTitleEn;

    /**
     * 文章副标题
     */
    private String articleSubTitle;

    /**
     * 文章英文副标题
     */
    private String articleSubTitleEn;

    /**
     * 文章内容
     */
    private String articleContent;

    /**
     * 文章英文内容
     */
    private String articleContentEn;

    /**
     * 文章摘要
     */
    private String articleSummary;

    /**
     * 文章英文摘要
     */
    private String articleSummaryEn;

    /**
     * 文章路径
     */
    private String articleUrl;

    /**
     * 文章封面图
     */
    private String articleImage;

    /**
     * 文章发布时间
     */
    private LocalDateTime publishTime;

    /**
     * 是否评论（0关闭 1开启）
     */
    private Integer isComment;

    /**
     * 是否推荐（0关闭 1开启）
     */
    private String isRecommend;

    /**
     * 分类排序
     */
    private Integer sort;

    /**
     * 是否启用（0草稿 1发布）
     */
    private Integer status;


}
