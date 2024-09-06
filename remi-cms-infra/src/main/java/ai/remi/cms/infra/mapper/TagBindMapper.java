package ai.remi.cms.infra.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import ai.remi.cms.domain.entity.TagBind;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author DianJiu
 * @email dianjiuxyz@gmail.com
 * @desc 标签绑定(TagBind)数据层
 */
@Mapper
public interface TagBindMapper extends BaseMapper<TagBind> {

}
