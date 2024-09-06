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
 * @desc 评论记录 LeaveDTO对象
 */
@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@TableName("cms_leave")
public class Leave extends BaseEntity {


    /**
     * 父级ID
     */
    private String parentId;

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
     * 是否审核（1评论 2留言 3建议 4反馈）
     */
    private Integer leaveType;

    /**
     * 评论内容
     */
    private String leaveContent;

    /**
     * 用户ID
     */
    private String userId;

    /**
     * 用户名称
     */
    private String userName;

    /**
     * 联系电话
     */
    private String phone;

    /**
     * 联系邮箱
     */
    private String email;

    /**
     * 是否审核（0未审 1审核）
     */
    private Integer status;


}
