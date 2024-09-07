package ai.remi.cms.infra.mapper;

import ai.remi.cms.domain.entity.Storage;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author DianJiu
 * @email dianjiuxyz@gmail.com
 * @desc 文件资源(Storage)数据层
 */
@Mapper
public interface StorageMapper extends BaseMapper<Storage> {

}
