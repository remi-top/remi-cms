package ai.remi.cms.server.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import ai.remi.cms.domain.entity.Image;
import ai.remi.cms.infra.mapper.ImageMapper;
import ai.remi.cms.server.service.ImageService;
import org.springframework.stereotype.Service;

/**
 * @author DianJiu
 * @email dianjiuxyz@gmail.com
 * @desc 图片管理(Image)服务实现层
 */
@Service("imageService")
public class ImageServiceImpl extends ServiceImpl<ImageMapper, Image> implements ImageService {

}

