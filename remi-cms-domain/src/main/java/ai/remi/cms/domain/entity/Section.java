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
 * @desc 栏目管理 SectionDTO对象
 */
@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@TableName("cms_section")
public class Section extends BaseEntity {


    /**
     * 父栏目ID
     */
    private String parentId;

    /**
     * 栏目编码
     */
    private String sectionCode;

    /**
     * 栏目名称
     */
    private String sectionName;

    /**
     * 栏目英文名称
     */
    private String sectionNameEn;

    /**
     * 栏目类型（1首页 2聚合页 3列表页 4内容页 5单页 6外链）
     */
    private Integer sectionType;

    /**
     * 栏目图标
     */
    private String sectionIcon;

    /**
     * 栏目描述
     */
    private String sectionRemark;

    /**
     * 显示顺序
     */
    private Integer sort;

    /**
     * 弹出方式（0当前窗口block 1新窗口_blank）
     */
    private Integer open;

    /**
     * 导航显示（0隐藏 1显示）
     */
    private Integer visible;

    /**
     * 是否启用（0停用 1启用）
     */
    private Integer status;


}
