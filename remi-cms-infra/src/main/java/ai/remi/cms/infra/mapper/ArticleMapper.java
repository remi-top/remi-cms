package ai.remi.cms.infra.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import ai.remi.cms.domain.entity.Article;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author DianJiu
 * @email dianjiuxyz@gmail.com
 * @desc 文章内容(Article)数据层
 */
@Mapper
public interface ArticleMapper extends BaseMapper<Article> {

}
