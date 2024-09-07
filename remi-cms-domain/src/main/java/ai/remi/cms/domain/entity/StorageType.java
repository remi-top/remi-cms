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
 * @desc 资源分类 StorageTypeDTO对象
 */
@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@TableName("cms_storage_type")
public class StorageType extends BaseEntity {


    /**
     * 分类编码
     */
    private String typeCode;

    /**
     * 分类名称
     */
    private String typeName;

    /**
     * 分类英文名称
     */
    private String typeNameEn;

    /**
     * 分类图标
     */
    private String typeIcon;

    /**
     * 分类描述
     */
    private String typeRemark;

    /**
     * 分类排序
     */
    private Integer sort;

    /**
     * 是否启用（0停用 1启用）
     */
    private Integer status;


}
