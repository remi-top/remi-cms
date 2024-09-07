package ai.remi.cms.infra.mapper;

import ai.remi.cms.domain.entity.ArticleType;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author DianJiu
 * @email dianjiuxyz@gmail.com
 * @desc 文章分类(ArticleType)数据层
 */
@Mapper
public interface ArticleTypeMapper extends BaseMapper<ArticleType> {

}
