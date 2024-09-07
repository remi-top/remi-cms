package ai.remi.cms.domain.dto.put;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author DianJiu
 * @email dianjiuxyz@gmail.com
 * @desc 全局配置 ConfigDTO对象
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)
@Schema(description = "全局配置")
public class ConfigPutDTO implements Serializable {
    private static final long serialVersionUID = -71995794134073416L;

    /**
     * ID
     */
    @Schema(description = "ID")
    private String id;

    /**
     * 配置项类型（1基础配置 2邮件配置 3存储配置 4主题信息 5插件配置 6客服配置 99其他配置）
     */
    @Schema(description = "配置项类型（1基础配置 2邮件配置 3存储配置 4主题信息 5插件配置 6客服配置 99其他配置）")
    private String type;

    /**
     * 配置项编码
     */
    @Schema(description = "配置项编码")
    private String code;

    /**
     * 配置项名称
     */
    @Schema(description = "配置项名称")
    private String name;

    /**
     * 配置项的值
     */
    @Schema(description = "配置项的值")
    private String value;

    /**
     * 是否启用（0停用 1启用）
     */
    @Schema(description = "是否启用（0停用 1启用）")
    private Integer status;


}
