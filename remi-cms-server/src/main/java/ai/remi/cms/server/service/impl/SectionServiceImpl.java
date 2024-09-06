package ai.remi.cms.server.service.impl;

import ai.remi.cms.domain.entity.Section;
import ai.remi.cms.infra.mapper.SectionMapper;
import ai.remi.cms.server.service.SectionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * @author DianJiu
 * @email dianjiuxyz@gmail.com
 * @desc 栏目管理(Section)服务实现层
 */
@Service("sectionService")
public class SectionServiceImpl extends ServiceImpl<SectionMapper, Section> implements SectionService {

}

