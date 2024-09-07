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
 * @desc 全局配置 ConfigDTO对象
 */
@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@TableName("cms_config")
public class Config extends BaseEntity {


    /**
     * 配置项类型（1基础配置 2邮件配置 3存储配置 4主题信息 5插件配置 6客服配置 99其他配置）
     */
    private String type;

    /**
     * 配置项编码
     */
    private String code;

    /**
     * 配置项名称
     */
    private String name;

    /**
     * 配置项的值
     */
    private String value;

    /**
     * 是否启用（0停用 1启用）
     */
    private Integer status;


}
