package ai.remi.cms.domain.dto.put;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author DianJiu
 * @email dianjiuxyz@gmail.com
 * @desc 友情链接 LinkDTO对象
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)
@Schema(description = "友情链接")
public class LinkPutDTO implements Serializable {
    private static final long serialVersionUID = -55025291964180537L;

    /**
     * ID
     */
    @Schema(description = "ID")
    private String id;

    /**
     * 链接类型
     */
    @Schema(description = "链接类型")
    private Integer linkType;

    /**
     * 网站名称
     */
    @Schema(description = "网站名称")
    private String linkName;

    /**
     * 网站英文名称
     */
    @Schema(description = "网站英文名称")
    private String linkNameEn;

    /**
     * 网站链接
     */
    @Schema(description = "网站链接")
    private String linkUrl;

    /**
     * 公司描述
     */
    @Schema(description = "公司描述")
    private String linkRemark;

    /**
     * 公司英文描述
     */
    @Schema(description = "公司英文描述")
    private String linkRemarkEn;

    /**
     * 网站排序
     */
    @Schema(description = "网站排序")
    private Integer sort;

    /**
     * 是否启用（0停用 1启用）
     */
    @Schema(description = "是否启用（0停用 1启用）")
    private Integer status;


}
