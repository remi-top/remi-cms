package ai.remi.cms.domain.converter;

import ai.remi.cms.domain.dto.post.StorageTypePostDTO;
import ai.remi.cms.domain.dto.put.StorageTypePutDTO;
import ai.remi.cms.domain.entity.StorageType;
import ai.remi.cms.domain.query.StorageTypeQuery;
import ai.remi.cms.domain.vo.StorageTypeVO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * @author DianJiu
 * @email dianjiuxyz@gmail.com
 * @desc 资源分类 StorageTypeConverter转换接口
 */
@Mapper
public interface StorageTypeConverter {

    StorageTypeConverter INSTANT = Mappers.getMapper(StorageTypeConverter.class);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "deleted", ignore = true)
    @Mapping(target = "revision", ignore = true)
    @Mapping(target = "deptTenantId", ignore = true)
    @Mapping(target = "companyTenantId", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedBy", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    StorageType postDtoToEntity(StorageTypePostDTO storageTypeDTO);

    @Mapping(target = "deleted", ignore = true)
    @Mapping(target = "revision", ignore = true)
    @Mapping(target = "deptTenantId", ignore = true)
    @Mapping(target = "companyTenantId", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedBy", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    StorageType putDtoToEntity(StorageTypePutDTO storageTypeDTO);

    @Mapping(target = "deleted", ignore = true)
    @Mapping(target = "revision", ignore = true)
    @Mapping(target = "deptTenantId", ignore = true)
    @Mapping(target = "companyTenantId", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedBy", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    StorageType queryToEntity(StorageTypeQuery storageTypeQuery);

    StorageTypeVO entityToVO(StorageType storageType);

}
