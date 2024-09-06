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
 * @desc 栏目管理 SectionVO对象
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)
@Schema(description = "栏目管理")
public class SectionVO implements Serializable {
    private static final long serialVersionUID = -13673913396602166L;
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
    /**
     * 是否删除（0可用 1删除）
     */
    @Schema(description = "是否删除（0可用 1删除）")
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
