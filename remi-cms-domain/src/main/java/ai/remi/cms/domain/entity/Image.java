package ai.remi.cms.domain.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import ai.remi.comm.domain.entity.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

/**
 * @author DianJiu
 * @email dianjiuxyz@gmail.com
 * @desc 图片管理 ImageDTO对象
 */
@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@TableName("cms_image")
public class Image extends BaseEntity {


    /**
     * 分类ID
     */
    private String typeId;

    /**
     * 分类编码
     */
    private String typeCode;

    /**
     * 文件ID
     */
    private String fileId;

    /**
     * 文件名称
     */
    private String fileName;

    /**
     * 文件类型
     */
    private String fileType;

    /**
     * 图片名称
     */
    private String imageName;

    /**
     * 图片大小
     */
    private String imageSize;

    /**
     * 预览地址
     */
    private String imageUrl;

    /**
     * 链接地址
     */
    private String linkUrl;

    /**
     * CDN地址
     */
    private String cdnUrl;

    /**
     * 图片宽
     */
    private String width;

    /**
     * 图片高
     */
    private String height;

    /**
     * 是否启用（0停用 1启用）
     */
    private Integer status;


}
