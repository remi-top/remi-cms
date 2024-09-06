package ai.remi.cms.domain.dto.put;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author DianJiu
 * @email dianjiuxyz@gmail.com
 * @desc 标签绑定 TagBindDTO对象
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)
@Schema(description = "标签绑定")
public class TagBindPutDTO implements Serializable {
    private static final long serialVersionUID = 758168473871756289L;

    /**
     * ID
     */
    @Schema(description = "ID")
    private String id;

    /**
     * 标签ID
     */
    @Schema(description = "标签ID")
    private String tagId;

    /**
     * 标签编码
     */
    @Schema(description = "标签编码")
    private String tagCode;

    /**
     * 关联类型（1文章 2图片 3视频）
     */
    @Schema(description = "关联类型（1文章 2图片 3视频）")
    private Integer bindType;

    /**
     * 关联ID
     */
    @Schema(description = "关联ID")
    private String bindId;

    /**
     * 关联编码
     */
    @Schema(description = "关联编码")
    private String bindCode;

    /**
     * 是否启用（0停用 1启用）
     */
    @Schema(description = "是否启用（0停用 1启用）")
    private Integer status;


}
