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
 * @desc 留言记录 MessageDTO对象
 */
@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@TableName("cms_message")
public class Message extends BaseEntity {


    /**
     * 留言者姓名
     */
    private String name;

    /**
     * 留言者邮箱
     */
    private String email;

    /**
     * 留言者电话
     */
    private String phone;

    /**
     * 留言的主题
     */
    private String subject;

    /**
     * 留言的内容
     */
    private String message;

    /**
     * 留言者的IP地址
     */
    private String ipAddress;

    /**
     * 留言者的浏览器
     */
    private String userAgent;

    /**
     * 关联的表单ID
     */
    private String formId;

    /**
     * 提交的动态数据，可以使用 JSON 格式存储。
     */
    private Object submission;

    /**
     * 是否启用（0停用 1启用）
     */
    private Integer status;


}
