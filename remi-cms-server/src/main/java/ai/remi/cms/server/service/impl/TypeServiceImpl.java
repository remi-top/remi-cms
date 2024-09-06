package ai.remi.cms.server.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import ai.remi.cms.domain.entity.Type;
import ai.remi.cms.infra.mapper.TypeMapper;
import ai.remi.cms.server.service.TypeService;
import org.springframework.stereotype.Service;

/**
 * @author DianJiu
 * @email dianjiuxyz@gmail.com
 * @desc 分类管理(Type)服务实现层
 */
@Service("typeService")
public class TypeServiceImpl extends ServiceImpl<TypeMapper, Type> implements TypeService {

}

