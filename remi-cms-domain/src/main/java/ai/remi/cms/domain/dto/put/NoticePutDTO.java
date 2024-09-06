package ai.remi.cms.domain.dto.put;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;

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
public class NoticePutDTO implements Serializable {
    private static final long serialVersionUID = 157250530127442776L;

    /**
     * ID
     */
    @Schema(description = "ID")
    private String id;

    /**
     * 通知类型
     */
    @Schema(description = "通知类型")
    private Integer noticeType;

    /**
     * 通知图标
     */
    @Schema(description = "通知图标")
    private String noticeIcon;

    /**
     * 通知内容
     */
    @Schema(description = "通知内容")
    private String noticeContent;

    /**
     * 通知英文内容
     */
    @Schema(description = "通知英文内容")
    private String noticeContentEn;

    /**
     * 链接地址
     */
    @Schema(description = "链接地址")
    private String linkUrl;

    /**
     * 是否启用（0停用 1启用）
     */
    @Schema(description = "是否启用（0停用 1启用）")
    private Integer status;


}
