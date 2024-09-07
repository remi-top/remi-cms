package ai.remi.cms.server.service.impl;

import ai.remi.cms.domain.entity.Message;
import ai.remi.cms.infra.mapper.MessageMapper;
import ai.remi.cms.server.service.MessageService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * @author DianJiu
 * @email dianjiuxyz@gmail.com
 * @desc 留言记录(Message)服务实现层
 */
@Service("messageService")
public class MessageServiceImpl extends ServiceImpl<MessageMapper, Message> implements MessageService {

}

