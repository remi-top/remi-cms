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
 * @desc 标签绑定 TagBindDTO对象
 */
@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@TableName("cms_tag_bind")
public class TagBind extends BaseEntity {


    /**
     * 标签ID
     */
    private String tagId;

    /**
     * 标签编码
     */
    private String tagCode;

    /**
     * 关联类型（1文章 2图片 3视频 4音频 5产品）
     */
    private Integer bindType;

    /**
     * 关联ID
     */
    private String bindId;

    /**
     * 关联编码
     */
    private String bindCode;

    /**
     * 是否启用（0停用 1启用）
     */
    private Integer status;


}
