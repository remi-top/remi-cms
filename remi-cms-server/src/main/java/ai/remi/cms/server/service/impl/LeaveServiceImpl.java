package ai.remi.cms.server.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import ai.remi.cms.domain.entity.Leave;
import ai.remi.cms.infra.mapper.LeaveMapper;
import ai.remi.cms.server.service.LeaveService;
import org.springframework.stereotype.Service;

/**
 * @author DianJiu
 * @email dianjiuxyz@gmail.com
 * @desc 评论记录(Leave)服务实现层
 */
@Service("leaveService")
public class LeaveServiceImpl extends ServiceImpl<LeaveMapper, Leave> implements LeaveService {

}

