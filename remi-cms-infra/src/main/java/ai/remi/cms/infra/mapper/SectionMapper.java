package ai.remi.cms.infra.mapper;

import ai.remi.cms.domain.entity.Section;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author DianJiu
 * @email dianjiuxyz@gmail.com
 * @desc 栏目管理(Section)数据层
 */
@Mapper
public interface SectionMapper extends BaseMapper<Section> {

}
