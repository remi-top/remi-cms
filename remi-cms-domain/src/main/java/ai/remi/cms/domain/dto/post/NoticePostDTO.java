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
 * @desc 通知公告 NoticeDTO对象
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)
@Schema(description = "通知公告")
public class NoticePostDTO implements Serializable {
    private static final long serialVersionUID = 283066681061397147L;


    /**
     * 公告图标
     */
    @Schema(description = "公告图标")
    private String noticeIcon;

    /**
     * 公告标题
     */
    @Schema(description = "公告标题")
    private String noticeTitle;

    /**
     * 公告内容
     */
    @Schema(description = "公告内容")
    private String noticeContent;

    /**
     * 公告英文内容
     */
    @Schema(description = "公告英文内容")
    private String noticeContentEn;

    /**
     * 浏览次数
     */
    @Schema(description = "浏览次数")
    private String views;

    /**
     * 优先级（1低 2中 3高）
     */
    @Schema(description = "优先级（1低 2中 3高）")
    private Integer priority;

    /**
     * 是否置顶（0正常 1置顶）
     */
    @Schema(description = "是否置顶（0正常 1置顶）")
    private Integer pinned;

    /**
     * 是否启用（0停用 1启用）
     */
    @Schema(description = "是否启用（0停用 1启用）")
    private Integer status;


    /**
     * 到期时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @Schema(description = "到期时间")
    private LocalDateTime expiresAt;

    /**
     * 发布时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @Schema(description = "发布时间")
    private LocalDateTime publishAt;


}
