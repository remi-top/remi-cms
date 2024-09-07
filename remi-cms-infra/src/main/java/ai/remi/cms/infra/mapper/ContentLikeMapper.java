package ai.remi.cms.infra.mapper;

import ai.remi.cms.domain.entity.ContentLike;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author DianJiu
 * @email dianjiuxyz@gmail.com
 * @desc 点赞记录(ContentLike)数据层
 */
@Mapper
public interface ContentLikeMapper extends BaseMapper<ContentLike> {

}
