package ai.remi.cms.server.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import ai.remi.cms.domain.entity.Like;
import ai.remi.cms.infra.mapper.LikeMapper;
import ai.remi.cms.server.service.LikeService;
import org.springframework.stereotype.Service;

/**
 * @author DianJiu
 * @email dianjiuxyz@gmail.com
 * @desc 点赞记录(Like)服务实现层
 */
@Service("likeService")
public class LikeServiceImpl extends ServiceImpl<LikeMapper, Like> implements LikeService {

}

