package ai.remi.cms.domain.converter;


import ai.remi.cms.domain.dto.post.ArticleTypePostDTO;
import ai.remi.cms.domain.dto.put.ArticleTypePutDTO;
import ai.remi.cms.domain.entity.ArticleType;
import ai.remi.cms.domain.query.ArticleTypeQuery;
import ai.remi.cms.domain.vo.ArticleTypeVO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * @author DianJiu
 * @email dianjiuxyz@gmail.com
 * @desc 文章分类 ArticleTypeConverter转换接口
 */
@Mapper
public interface ArticleTypeConverter {

    ArticleTypeConverter INSTANT = Mappers.getMapper(ArticleTypeConverter.class);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "deleted", ignore = true)
    @Mapping(target = "revision", ignore = true)
    @Mapping(target = "deptTenantId", ignore = true)
    @Mapping(target = "companyTenantId", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedBy", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    ArticleType postDtoToEntity(ArticleTypePostDTO articleTypeDTO);

    @Mapping(target = "deleted", ignore = true)
    @Mapping(target = "revision", ignore = true)
    @Mapping(target = "deptTenantId", ignore = true)
    @Mapping(target = "companyTenantId", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedBy", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    ArticleType putDtoToEntity(ArticleTypePutDTO articleTypeDTO);

    @Mapping(target = "deleted", ignore = true)
    @Mapping(target = "revision", ignore = true)
    @Mapping(target = "deptTenantId", ignore = true)
    @Mapping(target = "companyTenantId", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedBy", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    ArticleType queryToEntity(ArticleTypeQuery articleTypeQuery);

    ArticleTypeVO entityToVO(ArticleType articleType);

}
