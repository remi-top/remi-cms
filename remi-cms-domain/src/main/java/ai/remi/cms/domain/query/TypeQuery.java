package ai.remi.cms.domain.query;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author DianJiu
 * @email dianjiuxyz@gmail.com
 * @desc 分类管理 TypeQuery对象
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)
@Schema(description = "分类管理")
public class TypeQuery implements Serializable {
    private static final long serialVersionUID = -36263174188008359L;
    /**
     * ID
     */
    @Schema(description = "ID")
    private String id;
    /**
     * 父级分类
     */
    @Schema(description = "父级分类")
    private String parentId;
    /**
     * 分类编码
     */
    @Schema(description = "分类编码")
    private String typeCode;
    /**
     * 分类名称
     */
    @Schema(description = "分类名称")
    private String typeName;
    /**
     * 分类英文名称
     */
    @Schema(description = "分类英文名称")
    private String typeNameEn;
    /**
     * 分类图标
     */
    @Schema(description = "分类图标")
    private String typeIcon;
    /**
     * 分类排序
     */
    @Schema(description = "分类排序")
    private Integer sort;
    /**
     * 是否启用（0停用 1启用）
     */
    @Schema(description = "是否启用（0停用 1启用）")
    private Integer status;

}

