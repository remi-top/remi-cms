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
 * @desc 文件资源 StorageDTO对象
 */
@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@TableName("cms_storage")
public class Storage extends BaseEntity {


    /**
     * 文件编码
     */
    private String fileCode;

    /**
     * 文件名称
     */
    private String fileName;

    /**
     * 文件类型
     */
    private String fileType;

    /**
     * 存储路径
     */
    private String filePath;

    /**
     * 图片大小
     */
    private String fileSize;

    /**
     * 访问级别（1Public 2Private）
     */
    private Integer accessLevel;

    /**
     * MIME类型，用于存储文件的MIME类型（例如“application/pdf”）
     */
    private String mimeType;

    /**
     * 图片宽度，用于存储图片的宽度（像素）。
     */
    private Integer width;

    /**
     * 图片高度，用于存储图片的高度（像素）。
     */
    private Integer height;

    /**
     * 缩略图路径，用于显示文件的缩略图（适用于图片和视频）。
     */
    private String thumbnail;

    /**
     * 分辨率，用于存储图片或视频的分辨率（例如“1920x1080”）。
     */
    private String resolution;

    /**
     * 持续时间，用于存储音频或视频的持续时间（秒）。
     */
    private Integer duration;

    /**
     * 音频采样率，用于存储音频的采样率（Hz）。
     */
    private Integer sample;

    /**
     * 音频比特率，用于存储音频的比特率（kbps）
     */
    private Integer bitrate;

    /**
     * 音频通道数，用于存储音频的通道数（单声道或多声道）。
     */
    private Integer channels;

    /**
     * 文件校验和，用于验证文件完整性（例如MD5或SHA-256）。
     */
    private String checksum;

    /**
     * 上传者ID，外键，关联到 users 表。
     */
    private String uploader;

    /**
     * 其他元数据，可以是JSON格式，用于存储额外的信息。
     */
    private Object metadata;

    /**
     * 是否启用（0停用 1启用）
     */
    private Integer status;


}
