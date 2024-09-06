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
 * @desc 视频管理 VideoDTO对象
 */
@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@TableName("cms_video")
public class Video extends BaseEntity {


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
     * 视频名称
     */
    private String videoName;

    /**
     * 视频大小
     */
    private String videoSize;

    /**
     * 播放地址
     */
    private String videoUrl;

    /**
     * 缩略图
     */
    private String thumbnail;

    /**
     * 分辨率
     */
    private String resolution;

    /**
     * 是否启用（0停用 1启用）
     */
    private Integer status;


}
