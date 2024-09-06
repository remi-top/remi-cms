package ai.remi.cms.infra.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import ai.remi.cms.domain.entity.Link;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author DianJiu
 * @email dianjiuxyz@gmail.com
 * @desc 友情链接(Link)数据层
 */
@Mapper
public interface LinkMapper extends BaseMapper<Link> {

}
