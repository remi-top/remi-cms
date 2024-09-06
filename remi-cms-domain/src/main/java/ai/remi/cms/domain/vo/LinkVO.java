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
 * @desc 友情链接 LinkVO对象
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)
@Schema(description = "友情链接")
public class LinkVO implements Serializable {
    private static final long serialVersionUID = -97357960621793813L;
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
