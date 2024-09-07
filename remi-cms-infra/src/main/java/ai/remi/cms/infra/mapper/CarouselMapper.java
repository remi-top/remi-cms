package ai.remi.cms.infra.mapper;

import ai.remi.cms.domain.entity.Carousel;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author DianJiu
 * @email dianjiuxyz@gmail.com
 * @desc 轮播管理(Carousel)数据层
 */
@Mapper
public interface CarouselMapper extends BaseMapper<Carousel> {

}
