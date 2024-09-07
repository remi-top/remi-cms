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
 * @desc 友情链接 LinkDTO对象
 */
@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@TableName("cms_link")
public class Link extends BaseEntity {


    /**
     * 链接类型
     */
    private Integer linkType;

    /**
     * 网站名称
     */
    private String linkName;

    /**
     * 网站英文名称
     */
    private String linkNameEn;

    /**
     * 网站链接
     */
    private String linkUrl;

    /**
     * 公司描述
     */
    private String linkRemark;

    /**
     * 公司英文描述
     */
    private String linkRemarkEn;

    /**
     * 网站排序
     */
    private Integer sort;

    /**
     * 是否启用（0停用 1启用）
     */
    private Integer status;


}
