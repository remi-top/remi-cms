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
 * @desc 留言记录 MessageVO对象
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)
@Schema(description = "留言记录")
public class MessageVO implements Serializable {
    private static final long serialVersionUID = -24405521870832387L;
    /**
     * ID
     */
    @Schema(description = "ID")
    private String id;
    /**
     * 留言者姓名
     */
    @Schema(description = "留言者姓名")
    private String name;
    /**
     * 留言者邮箱
     */
    @Schema(description = "留言者邮箱")
    private String email;
    /**
     * 留言者电话
     */
    @Schema(description = "留言者电话")
    private String phone;
    /**
     * 留言的主题
     */
    @Schema(description = "留言的主题")
    private String subject;
    /**
     * 留言的内容
     */
    @Schema(description = "留言的内容")
    private String message;
    /**
     * 留言者的IP地址
     */
    @Schema(description = "留言者的IP地址")
    private String ipAddress;
    /**
     * 留言者的浏览器
     */
    @Schema(description = "留言者的浏览器")
    private String userAgent;
    /**
     * 关联的表单ID
     */
    @Schema(description = "关联的表单ID")
    private String formId;
    /**
     * 提交的动态数据，可以使用 JSON 格式存储。
     */
    @Schema(description = "提交的动态数据，可以使用 JSON 格式存储。")
    private Object submission;
    /**
     * 是否启用（0停用 1启用）
     */
    @Schema(description = "是否启用（0停用 1启用）")
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
