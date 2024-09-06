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
 * @desc 分类管理 TypeDTO对象
 */
@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@TableName("cms_type")
public class Type extends BaseEntity {


    /**
     * 父级分类
     */
    private String parentId;

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
     * 分类排序
     */
    private Integer sort;

    /**
     * 是否启用（0停用 1启用）
     */
    private Integer status;


}
