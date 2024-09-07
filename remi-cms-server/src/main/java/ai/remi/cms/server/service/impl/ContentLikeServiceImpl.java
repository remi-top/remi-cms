package ai.remi.cms.server.service.impl;

import ai.remi.cms.domain.entity.ContentLike;
import ai.remi.cms.infra.mapper.ContentLikeMapper;
import ai.remi.cms.server.service.ContentLikeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * @author DianJiu
 * @email dianjiuxyz@gmail.com
 * @desc 点赞记录(ContentLike)服务实现层
 */
@Service("contentLikeService")
public class ContentLikeServiceImpl extends ServiceImpl<ContentLikeMapper, ContentLike> implements ContentLikeService {

}

