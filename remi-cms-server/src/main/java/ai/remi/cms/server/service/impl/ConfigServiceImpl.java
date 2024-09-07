package ai.remi.cms.server.service.impl;

import ai.remi.cms.domain.entity.Config;
import ai.remi.cms.infra.mapper.ConfigMapper;
import ai.remi.cms.server.service.ConfigService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * @author DianJiu
 * @email dianjiuxyz@gmail.com
 * @desc 全局配置(Config)服务实现层
 */
@Service("configService")
public class ConfigServiceImpl extends ServiceImpl<ConfigMapper, Config> implements ConfigService {

}

