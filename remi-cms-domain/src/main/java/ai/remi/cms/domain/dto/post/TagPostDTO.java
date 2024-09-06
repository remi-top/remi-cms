package ai.remi.cms.domain.dto.post;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author DianJiu
 * @email dianjiuxyz@gmail.com
 * @desc 标签管理 TagDTO对象
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)
@Schema(description = "标签管理")
public class TagPostDTO implements Serializable {
    private static final long serialVersionUID = -94504678306519945L;


    /**
     * 标签编码
     */
    @Schema(description = "标签编码")
    private String tagCode;

    /**
     * 标签名称
     */
    @Schema(description = "标签名称")
    private String tagName;

    /**
     * 标签英文名称
     */
    @Schema(description = "标签英文名称")
    private String tagNameEn;

    /**
     * 是否启用（0停用 1启用）
     */
    @Schema(description = "是否启用（0停用 1启用）")
    private Integer status;


}
