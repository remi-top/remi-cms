package ai.remi.cms.infra.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import ai.remi.cms.domain.entity.Image;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author DianJiu
 * @email dianjiuxyz@gmail.com
 * @desc 图片管理(Image)数据层
 */
@Mapper
public interface ImageMapper extends BaseMapper<Image> {

}
