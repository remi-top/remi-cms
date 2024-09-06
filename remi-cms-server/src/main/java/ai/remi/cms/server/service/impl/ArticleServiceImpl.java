package ai.remi.cms.server.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import ai.remi.cms.domain.entity.Article;
import ai.remi.cms.infra.mapper.ArticleMapper;
import ai.remi.cms.server.service.ArticleService;
import org.springframework.stereotype.Service;

/**
 * @author DianJiu
 * @email dianjiuxyz@gmail.com
 * @desc 文章内容(Article)服务实现层
 */
@Service("articleService")
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, Article> implements ArticleService {

}

