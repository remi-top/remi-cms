package ai.remi.cms.server.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import ai.remi.cms.domain.entity.Keep;
import ai.remi.cms.infra.mapper.KeepMapper;
import ai.remi.cms.server.service.KeepService;
import org.springframework.stereotype.Service;

/**
 * @author DianJiu
 * @email dianjiuxyz@gmail.com
 * @desc 收藏记录(Keep)服务实现层
 */
@Service("keepService")
public class KeepServiceImpl extends ServiceImpl<KeepMapper, Keep> implements KeepService {

}

