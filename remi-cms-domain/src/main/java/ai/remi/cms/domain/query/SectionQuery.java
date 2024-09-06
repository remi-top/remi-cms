package ai.remi.cms.domain.query;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author DianJiu
 * @email dianjiuxyz@gmail.com
 * @desc 栏目管理 SectionQuery对象
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)
@Schema(description = "栏目管理")
public class SectionQuery implements Serializable {
    private static final long serialVersionUID = 589805616228947369L;
    /**
     * ID
     */
    @Schema(description = "ID")
    private String id;
    /**
     * 父栏目ID
     */
    @Schema(description = "父栏目ID")
    private String parentId;
    /**
     * 栏目编码
     */
    @Schema(description = "栏目编码")
    private String sectionCode;
    /**
     * 栏目名称
     */
    @Schema(description = "栏目名称")
    private String sectionName;
    /**
     * 栏目英文名称
     */
    @Schema(description = "栏目英文名称")
    private String sectionNameEn;
    /**
     * 栏目类型（1首页 2聚合页 3列表页 4内容页 4单页 5外链）
     */
    @Schema(description = "栏目类型（1首页 2聚合页 3列表页 4内容页 4单页 5外链）")
    private Integer sectionType;
    /**
     * 栏目图标
     */
    @Schema(description = "栏目图标")
    private String sectionIcon;
    /**
     * 栏目描述
     */
    @Schema(description = "栏目描述")
    private String sectionRemark;
    /**
     * 显示顺序
     */
    @Schema(description = "显示顺序")
    private Integer sort;
    /**
     * 弹出方式（0当前窗口block 1新窗口_blank）
     */
    @Schema(description = "弹出方式（0当前窗口block 1新窗口_blank）")
    private Integer open;
    /**
     * 导航显示（0隐藏 1显示）
     */
    @Schema(description = "导航显示（0隐藏 1显示）")
    private Integer visible;
    /**
     * 是否启用（0停用 1启用）
     */
    @Schema(description = "是否启用（0停用 1启用）")
    private Integer status;

}

