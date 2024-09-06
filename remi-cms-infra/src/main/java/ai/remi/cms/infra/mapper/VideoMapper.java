package ai.remi.cms.infra.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import ai.remi.cms.domain.entity.Video;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author DianJiu
 * @email dianjiuxyz@gmail.com
 * @desc 视频管理(Video)数据层
 */
@Mapper
public interface VideoMapper extends BaseMapper<Video> {

}
