package ai.remi.cms.infra.mapper;

import ai.remi.cms.domain.entity.ContentComment;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author DianJiu
 * @email dianjiuxyz@gmail.com
 * @desc 评论记录(ContentComment)数据层
 */
@Mapper
public interface ContentCommentMapper extends BaseMapper<ContentComment> {

}
