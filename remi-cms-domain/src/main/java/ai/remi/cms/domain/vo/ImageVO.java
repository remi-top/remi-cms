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
 * @desc 图片管理 ImageVO对象
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)
@Schema(description = "图片管理")
public class ImageVO implements Serializable {
    private static final long serialVersionUID = 180298650697810103L;
    /**
     * ID
     */
    @Schema(description = "ID")
    private String id;
    /**
     * 分类ID
     */
    @Schema(description = "分类ID")
    private String typeId;
    /**
     * 分类编码
     */
    @Schema(description = "分类编码")
    private String typeCode;
    /**
     * 文件ID
     */
    @Schema(description = "文件ID")
    private String fileId;
    /**
     * 文件名称
     */
    @Schema(description = "文件名称")
    private String fileName;
    /**
     * 文件类型
     */
    @Schema(description = "文件类型")
    private String fileType;
    /**
     * 图片名称
     */
    @Schema(description = "图片名称")
    private String imageName;
    /**
     * 图片大小
     */
    @Schema(description = "图片大小")
    private String imageSize;
    /**
     * 预览地址
     */
    @Schema(description = "预览地址")
    private String imageUrl;
    /**
     * 链接地址
     */
    @Schema(description = "链接地址")
    private String linkUrl;
    /**
     * CDN地址
     */
    @Schema(description = "CDN地址")
    private String cdnUrl;
    /**
     * 图片宽
     */
    @Schema(description = "图片宽")
    private String width;
    /**
     * 图片高
     */
    @Schema(description = "图片高")
    private String height;
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
