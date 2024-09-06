package ai.remi.cms.infra.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import ai.remi.cms.domain.entity.Like;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author DianJiu
 * @email dianjiuxyz@gmail.com
 * @desc 点赞记录(Like)数据层
 */
@Mapper
public interface LikeMapper extends BaseMapper<Like> {

}
