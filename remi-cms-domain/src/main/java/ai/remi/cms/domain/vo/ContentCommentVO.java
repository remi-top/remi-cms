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
 * @desc 评论记录 ContentCommentVO对象
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)
@Schema(description = "评论记录")
public class ContentCommentVO implements Serializable {
    private static final long serialVersionUID = -24160920440907802L;
    /**
     * ID
     */
    @Schema(description = "ID")
    private String id;
    /**
     * 父级ID
     */
    @Schema(description = "父级ID")
    private String parentId;
    /**
     * 关联类型（1文章 2图片 3视频）
     */
    @Schema(description = "关联类型（1文章 2图片 3视频）")
    private Integer bindType;
    /**
     * 关联表ID
     */
    @Schema(description = "关联表ID")
    private String bindId;
    /**
     * 关联表编码
     */
    @Schema(description = "关联表编码")
    private String bindCode;
    /**
     * 评论内容
     */
    @Schema(description = "评论内容")
    private String content;
    /**
     * 用户ID
     */
    @Schema(description = "用户ID")
    private String userId;
    /**
     * 用户名称
     */
    @Schema(description = "用户名称")
    private String userName;
    /**
     * 用户头像
     */
    @Schema(description = "用户头像")
    private String userAvatar;
    /**
     * 联系电话
     */
    @Schema(description = "联系电话")
    private String phone;
    /**
     * 联系邮箱
     */
    @Schema(description = "联系邮箱")
    private String email;
    /**
     * 是否审核（0未审 1审核）
     */
    @Schema(description = "是否审核（0未审 1审核）")
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
