package ai.remi.cms.domain.dto.post;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author DianJiu
 * @email dianjiuxyz@gmail.com
 * @desc 视频管理 VideoDTO对象
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)
@Schema(description = "视频管理")
public class VideoPostDTO implements Serializable {
    private static final long serialVersionUID = 908980694787696975L;


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
     * 视频名称
     */
    @Schema(description = "视频名称")
    private String videoName;

    /**
     * 视频大小
     */
    @Schema(description = "视频大小")
    private String videoSize;

    /**
     * 播放地址
     */
    @Schema(description = "播放地址")
    private String videoUrl;

    /**
     * 缩略图
     */
    @Schema(description = "缩略图")
    private String thumbnail;

    /**
     * 分辨率
     */
    @Schema(description = "分辨率")
    private String resolution;

    /**
     * 是否启用（0停用 1启用）
     */
    @Schema(description = "是否启用（0停用 1启用）")
    private Integer status;


}
