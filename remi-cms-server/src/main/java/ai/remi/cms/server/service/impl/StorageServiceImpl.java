package ai.remi.cms.server.service.impl;

import ai.remi.cms.domain.entity.Storage;
import ai.remi.cms.infra.mapper.StorageMapper;
import ai.remi.cms.server.service.StorageService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * @author DianJiu
 * @email dianjiuxyz@gmail.com
 * @desc 文件资源(Storage)服务实现层
 */
@Service("storageService")
public class StorageServiceImpl extends ServiceImpl<StorageMapper, Storage> implements StorageService {

}

