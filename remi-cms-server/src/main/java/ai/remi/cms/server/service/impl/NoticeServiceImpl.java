package ai.remi.cms.server.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import ai.remi.cms.domain.entity.Notice;
import ai.remi.cms.infra.mapper.NoticeMapper;
import ai.remi.cms.server.service.NoticeService;
import org.springframework.stereotype.Service;

/**
 * @author DianJiu
 * @email dianjiuxyz@gmail.com
 * @desc 通知公告(Notice)服务实现层
 */
@Service("noticeService")
public class NoticeServiceImpl extends ServiceImpl<NoticeMapper, Notice> implements NoticeService {

}

