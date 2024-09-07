package ai.remi.cms.server.service.impl;

import ai.remi.cms.domain.entity.Carousel;
import ai.remi.cms.infra.mapper.CarouselMapper;
import ai.remi.cms.server.service.CarouselService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * @author DianJiu
 * @email dianjiuxyz@gmail.com
 * @desc 轮播管理(Carousel)服务实现层
 */
@Service("carouselService")
public class CarouselServiceImpl extends ServiceImpl<CarouselMapper, Carousel> implements CarouselService {

}

