package ai.remi.cms.domain.dto.post;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author DianJiu
 * @email dianjiuxyz@gmail.com
 * @desc 留言记录 MessageDTO对象
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)
@Schema(description = "留言记录")
public class MessagePostDTO implements Serializable {
    private static final long serialVersionUID = -10418561693294045L;


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


}
