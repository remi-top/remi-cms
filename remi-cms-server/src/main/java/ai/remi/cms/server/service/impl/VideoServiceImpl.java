package ai.remi.cms.server.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import ai.remi.cms.domain.entity.Video;
import ai.remi.cms.infra.mapper.VideoMapper;
import ai.remi.cms.server.service.VideoService;
import org.springframework.stereotype.Service;

/**
 * @author DianJiu
 * @email dianjiuxyz@gmail.com
 * @desc 视频管理(Video)服务实现层
 */
@Service("videoService")
public class VideoServiceImpl extends ServiceImpl<VideoMapper, Video> implements VideoService {

}

