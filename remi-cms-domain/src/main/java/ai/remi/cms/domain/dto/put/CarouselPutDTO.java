package ai.remi.cms.domain.dto.put;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author DianJiu
 * @email dianjiuxyz@gmail.com
 * @desc 轮播管理 CarouselDTO对象
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)
@Schema(description = "轮播管理")
public class CarouselPutDTO implements Serializable {
    private static final long serialVersionUID = -24426460820569419L;

    /**
     * ID
     */
    @Schema(description = "ID")
    private String id;

    /**
     * 轮播类型（1图片 2视频）
     */
    @Schema(description = "轮播类型（1图片 2视频）")
    private Integer carouselType;

    /**
     * 资源路径或外部链接
     */
    @Schema(description = "资源路径或外部链接")
    private String storageUrl;

    /**
     * 点击后跳转地址
     */
    @Schema(description = "点击后跳转地址")
    private String targetUrl;

    /**
     * 轮播标题
     */
    @Schema(description = "轮播标题")
    private String carouselTitle;

    /**
     * 轮播标题英文
     */
    @Schema(description = "轮播标题英文")
    private String carouselTitleEn;

    /**
     * 轮播副标题
     */
    @Schema(description = "轮播副标题")
    private String carouselSubTitle;

    /**
     * 轮播副标题英文
     */
    @Schema(description = "轮播副标题英文")
    private String carouselSubTitleEn;

    /**
     * 轮播描述
     */
    @Schema(description = "轮播描述")
    private String carouselRemark;

    /**
     * 轮播描述英文
     */
    @Schema(description = "轮播描述英文")
    private String carouselRemarkEn;

    /**
     * 轮播排序
     */
    @Schema(description = "轮播排序")
    private Integer sort;

    /**
     * 是否启用（0停用 1启用）
     */
    @Schema(description = "是否启用（0停用 1启用）")
    private Integer status;


}
