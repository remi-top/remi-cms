package ai.remi.cms.server.service.impl;

import ai.remi.cms.domain.entity.TagBind;
import ai.remi.cms.infra.mapper.TagBindMapper;
import ai.remi.cms.server.service.TagBindService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * @author DianJiu
 * @email dianjiuxyz@gmail.com
 * @desc 标签绑定(TagBind)服务实现层
 */
@Service("tagBindService")
public class TagBindServiceImpl extends ServiceImpl<TagBindMapper, TagBind> implements TagBindService {

}

