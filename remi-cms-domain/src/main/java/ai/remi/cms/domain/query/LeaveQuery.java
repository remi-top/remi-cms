package ai.remi.cms.domain.query;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author DianJiu
 * @email dianjiuxyz@gmail.com
 * @desc 评论记录 LeaveQuery对象
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)
@Schema(description = "评论记录")
public class LeaveQuery implements Serializable {
    private static final long serialVersionUID = -50077018041280911L;
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
     * 是否审核（1评论 2留言 3建议 4反馈）
     */
    @Schema(description = "是否审核（1评论 2留言 3建议 4反馈）")
    private Integer leaveType;
    /**
     * 评论内容
     */
    @Schema(description = "评论内容")
    private String leaveContent;
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

}

