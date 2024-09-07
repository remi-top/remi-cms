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
 * @desc 文章分类 ArticleTypeVO对象
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)
@Schema(description = "文章分类")
public class ArticleTypeVO implements Serializable {
    private static final long serialVersionUID = -28301315242905695L;
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
     * 分类描述
     */
    @Schema(description = "分类描述")
    private String typeRemark;
    /**
     * 分类英文描述
     */
    @Schema(description = "分类英文描述")
    private String typeRemarkEn;
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
    /**
     * 是否删除（0正常 1删除）
     */
    @Schema(description = "是否删除（0正常 1删除）")
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
