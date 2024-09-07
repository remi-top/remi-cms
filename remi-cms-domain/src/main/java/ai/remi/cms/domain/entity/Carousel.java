package ai.remi.cms.domain.entity;


import ai.remi.comm.domain.entity.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

/**
 * @author DianJiu
 * @email dianjiuxyz@gmail.com
 * @desc 轮播管理 CarouselDTO对象
 */
@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@TableName("cms_carousel")
public class Carousel extends BaseEntity {


    /**
     * 轮播类型（1图片 2视频）
     */
    private Integer carouselType;

    /**
     * 资源路径或外部链接
     */
    private String storageUrl;

    /**
     * 点击后跳转地址
     */
    private String targetUrl;

    /**
     * 轮播标题
     */
    private String carouselTitle;

    /**
     * 轮播标题英文
     */
    private String carouselTitleEn;

    /**
     * 轮播副标题
     */
    private String carouselSubTitle;

    /**
     * 轮播副标题英文
     */
    private String carouselSubTitleEn;

    /**
     * 轮播描述
     */
    private String carouselRemark;

    /**
     * 轮播描述英文
     */
    private String carouselRemarkEn;

    /**
     * 轮播排序
     */
    private Integer sort;

    /**
     * 是否启用（0停用 1启用）
     */
    private Integer status;


}
