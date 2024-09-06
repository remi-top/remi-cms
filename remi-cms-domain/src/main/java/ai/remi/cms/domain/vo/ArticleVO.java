package ai.remi.cms.domain.vo;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @author DianJiu
 * @email dianjiuxyz@gmail.com
 * @desc 文章内容 ArticleVO对象
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)
@Schema(description = "文章内容")
public class ArticleVO implements Serializable {
    private static final long serialVersionUID = -77677911112648159L;
    /**
     * ID
     */
    @Schema(description = "ID")
    private String id;
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
     * 文章副标题
     */
    @Schema(description = "文章副标题")
    private String articleSubTitle;
    /**
     * 文章内容
     */
    @Schema(description = "文章内容")
    private String articleContent;
    /**
     * 文章摘要
     */
    @Schema(description = "文章摘要")
    private String articleSummary;
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
    /**
     * 是否删除（0正常 1删除）
     */
    @Schema(description = "是否删除（0正常 1删除）")
    private Integer deleted;
    /**
     * 乐观锁
     */
    @Schema(description = "乐观锁")
    private Integer revision;
    /**
     * 部门租户ID
     */
    @Schema(description = "部门租户ID")
    private String deptTenantId;
    /**
     * 公司租户ID
     */
    @Schema(description = "公司租户ID")
    private String companyTenantId;
    /**
     * 创建人
     */
    @Schema(description = "创建人")
    private String createdBy;
    /**
     * 创建时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @Schema(description = "创建时间")
    private LocalDateTime createdAt;
    /**
     * 更新人
     */
    @Schema(description = "更新人")
    private String updatedBy;
    /**
     * 更新时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @Schema(description = "更新时间")
    private LocalDateTime updatedAt;

}
