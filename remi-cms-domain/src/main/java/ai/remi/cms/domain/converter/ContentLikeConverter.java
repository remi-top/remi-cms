package ai.remi.cms.domain.converter;


import ai.remi.cms.domain.dto.post.ContentLikePostDTO;
import ai.remi.cms.domain.dto.put.ContentLikePutDTO;
import ai.remi.cms.domain.entity.ContentLike;
import ai.remi.cms.domain.query.ContentLikeQuery;
import ai.remi.cms.domain.vo.ContentLikeVO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * @author DianJiu
 * @email dianjiuxyz@gmail.com
 * @desc 点赞记录 ContentLikeConverter转换接口
 */
@Mapper
public interface ContentLikeConverter {

    ContentLikeConverter INSTANT = Mappers.getMapper(ContentLikeConverter.class);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "deleted", ignore = true)
    @Mapping(target = "revision", ignore = true)
    @Mapping(target = "deptTenantId", ignore = true)
    @Mapping(target = "companyTenantId", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedBy", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    ContentLike postDtoToEntity(ContentLikePostDTO contentLikeDTO);

    @Mapping(target = "deleted", ignore = true)
    @Mapping(target = "revision", ignore = true)
    @Mapping(target = "deptTenantId", ignore = true)
    @Mapping(target = "companyTenantId", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedBy", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    ContentLike putDtoToEntity(ContentLikePutDTO contentLikeDTO);

    @Mapping(target = "deleted", ignore = true)
    @Mapping(target = "revision", ignore = true)
    @Mapping(target = "deptTenantId", ignore = true)
    @Mapping(target = "companyTenantId", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedBy", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    ContentLike queryToEntity(ContentLikeQuery contentLikeQuery);

    ContentLikeVO entityToVO(ContentLike contentLike);

}
