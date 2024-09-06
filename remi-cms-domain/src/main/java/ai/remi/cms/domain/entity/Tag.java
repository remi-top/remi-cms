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
 * @desc 标签管理 TagDTO对象
 */
@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@TableName("cms_tag")
public class Tag extends BaseEntity {


    /**
     * 标签编码
     */
    private String tagCode;

    /**
     * 标签名称
     */
    private String tagName;

    /**
     * 标签英文名称
     */
    private String tagNameEn;

    /**
     * 是否启用（0停用 1启用）
     */
    private Integer status;


}
