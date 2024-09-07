package ai.remi.cms.domain.query;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author DianJiu
 * @email dianjiuxyz@gmail.com
 * @desc 点赞记录 ContentLikeQuery对象
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)
@Schema(description = "点赞记录")
public class ContentLikeQuery implements Serializable {
    private static final long serialVersionUID = -23923245066655922L;
    /**
     * ID
     */
    @Schema(description = "ID")
    private String id;
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
     * 用户ID
     */
    @Schema(description = "用户ID")
    private String userId;
    /**
     * 是否启用（0停用 1启用）
     */
    @Schema(description = "是否启用（0停用 1启用）")
    private Integer status;

}

