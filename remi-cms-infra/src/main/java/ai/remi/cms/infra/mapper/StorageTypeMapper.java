package ai.remi.cms.infra.mapper;

import ai.remi.cms.domain.entity.StorageType;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author DianJiu
 * @email dianjiuxyz@gmail.com
 * @desc 资源分类(StorageType)数据层
 */
@Mapper
public interface StorageTypeMapper extends BaseMapper<StorageType> {

}
