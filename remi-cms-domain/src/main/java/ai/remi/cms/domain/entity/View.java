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
 * @desc 查看记录 ViewDTO对象
 */
@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@TableName("cms_view")
public class View extends BaseEntity {


    /**
     * 关联类型（1文章 2图片 3视频）
     */
    private Integer bindType;

    /**
     * 关联表ID
     */
    private String bindId;

    /**
     * 关联表编码
     */
    private String bindCode;

    /**
     * 用户ID
     */
    private String userId;

    /**
     * 是否启用（0停用 1启用）
     */
    private Integer status;


}
