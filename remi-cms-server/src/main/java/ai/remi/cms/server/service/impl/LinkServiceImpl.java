package ai.remi.cms.server.service.impl;

import ai.remi.cms.domain.entity.Link;
import ai.remi.cms.infra.mapper.LinkMapper;
import ai.remi.cms.server.service.LinkService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * @author DianJiu
 * @email dianjiuxyz@gmail.com
 * @desc 友情链接(Link)服务实现层
 */
@Service("linkService")
public class LinkServiceImpl extends ServiceImpl<LinkMapper, Link> implements LinkService {

}

