package ai.remi.cms.server.service.impl;

import ai.remi.cms.domain.entity.ArticleType;
import ai.remi.cms.infra.mapper.ArticleTypeMapper;
import ai.remi.cms.server.service.ArticleTypeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * @author DianJiu
 * @email dianjiuxyz@gmail.com
 * @desc 文章分类(ArticleType)服务实现层
 */
@Service("articleTypeService")
public class ArticleTypeServiceImpl extends ServiceImpl<ArticleTypeMapper, ArticleType> implements ArticleTypeService {

}

