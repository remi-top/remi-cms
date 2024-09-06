package ai.remi.cms.server.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import ai.remi.cms.domain.entity.Repost;
import ai.remi.cms.infra.mapper.RepostMapper;
import ai.remi.cms.server.service.RepostService;
import org.springframework.stereotype.Service;

/**
 * @author DianJiu
 * @email dianjiuxyz@gmail.com
 * @desc 转发记录(Repost)服务实现层
 */
@Service("repostService")
public class RepostServiceImpl extends ServiceImpl<RepostMapper, Repost> implements RepostService {

}

