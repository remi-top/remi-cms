package ai.remi.cms.domain.entity;

import ai.remi.comm.domain.entity.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

/**
 * @author DianJiu
 * @email dianjiuxyz@gmail.com
 * @desc 通知公告 NoticeDTO对象
 */
@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@TableName("cms_notice")
public class Notice extends BaseEntity {


    /**
     * 公告图标
     */
    private String noticeIcon;

    /**
     * 公告标题
     */
    private String noticeTitle;

    /**
     * 公告内容
     */
    private String noticeContent;

    /**
     * 公告英文内容
     */
    private String noticeContentEn;

    /**
     * 浏览次数
     */
    private String views;

    /**
     * 优先级（1低 2中 3高）
     */
    private Integer priority;

    /**
     * 是否置顶（0正常 1置顶）
     */
    private Integer pinned;

    /**
     * 是否启用（0停用 1启用）
     */
    private Integer status;


    /**
     * 到期时间
     */
    private LocalDateTime expiresAt;

    /**
     * 发布时间
     */
    private LocalDateTime publishAt;


}
