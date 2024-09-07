package ai.remi.cms.domain.dto.post;


import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author DianJiu
 * @email dianjiuxyz@gmail.com
 * @desc 文章内容 ArticleDTO对象
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)
@Schema(description = "文章内容")
public class ArticlePostDTO implements Serializable {
    private static final long serialVersionUID = 915367507235264846L;


    /**
     * 分类ID
     */
    @Schema(description = "分类ID")
    private String typeId;

    /**
     * 分类编码
     */
    @Schema(description = "分类编码")
    private String typeCode;

    /**
     * 文章类型（1原创 2转载 3翻译）
     */
    @Schema(description = "文章类型（1原创 2转载 3翻译）")
    private Integer articleType;

    /**
     * 文章标题
     */
    @Schema(description = "文章标题")
    private String articleTitle;

    /**
     * 文章英文标题
     */
    @Schema(description = "文章英文标题")
    private String articleTitleEn;

    /**
     * 文章副标题
     */
    @Schema(description = "文章副标题")
    private String articleSubTitle;

    /**
     * 文章英文副标题
     */
    @Schema(description = "文章英文副标题")
    private String articleSubTitleEn;

    /**
     * 文章内容
     */
    @Schema(description = "文章内容")
    private String articleContent;

    /**
     * 文章英文内容
     */
    @Schema(description = "文章英文内容")
    private String articleContentEn;

    /**
     * 文章摘要
     */
    @Schema(description = "文章摘要")
    private String articleSummary;

    /**
     * 文章英文摘要
     */
    @Schema(description = "文章英文摘要")
    private String articleSummaryEn;

    /**
     * 文章路径
     */
    @Schema(description = "文章路径")
    private String articleUrl;

    /**
     * 文章封面图
     */
    @Schema(description = "文章封面图")
    private String articleImage;

    /**
     * 文章发布时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @Schema(description = "文章发布时间")
    private LocalDateTime publishTime;

    /**
     * 是否评论（0关闭 1开启）
     */
    @Schema(description = "是否评论（0关闭 1开启）")
    private Integer isComment;

    /**
     * 是否推荐（0关闭 1开启）
     */
    @Schema(description = "是否推荐（0关闭 1开启）")
    private String isRecommend;

    /**
     * 分类排序
     */
    @Schema(description = "分类排序")
    private Integer sort;

    /**
     * 是否启用（0草稿 1发布）
     */
    @Schema(description = "是否启用（0草稿 1发布）")
    private Integer status;


}
