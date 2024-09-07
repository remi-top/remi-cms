package ai.remi.cms.server.service.impl;

import ai.remi.cms.domain.entity.ContentComment;
import ai.remi.cms.infra.mapper.ContentCommentMapper;
import ai.remi.cms.server.service.ContentCommentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * @author DianJiu
 * @email dianjiuxyz@gmail.com
 * @desc 评论记录(ContentComment)服务实现层
 */
@Service("contentCommentService")
public class ContentCommentServiceImpl extends ServiceImpl<ContentCommentMapper, ContentComment> implements ContentCommentService {

}

