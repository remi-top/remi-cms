package ai.remi.cms.infra.mapper;

import ai.remi.cms.domain.entity.Tag;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author DianJiu
 * @email dianjiuxyz@gmail.com
 * @desc 标签管理(Tag)数据层
 */
@Mapper
public interface TagMapper extends BaseMapper<Tag> {

}
