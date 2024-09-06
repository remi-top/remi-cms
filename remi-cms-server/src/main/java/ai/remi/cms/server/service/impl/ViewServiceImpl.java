package ai.remi.cms.server.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import ai.remi.cms.domain.entity.View;
import ai.remi.cms.infra.mapper.ViewMapper;
import ai.remi.cms.server.service.ViewService;
import org.springframework.stereotype.Service;

/**
 * @author DianJiu
 * @email dianjiuxyz@gmail.com
 * @desc 查看记录(View)服务实现层
 */
@Service("viewService")
public class ViewServiceImpl extends ServiceImpl<ViewMapper, View> implements ViewService {

}

