package ai.remi.cms.server.service.impl;

import ai.remi.cms.domain.entity.StorageType;
import ai.remi.cms.infra.mapper.StorageTypeMapper;
import ai.remi.cms.server.service.StorageTypeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * @author DianJiu
 * @email dianjiuxyz@gmail.com
 * @desc 资源分类(StorageType)服务实现层
 */
@Service("storageTypeService")
public class StorageTypeServiceImpl extends ServiceImpl<StorageTypeMapper, StorageType> implements StorageTypeService {

}

