package ba.sake.cakum_pakum.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import ba.sake.cakum_pakum.rdb.models.BlogPostEntity;
import ba.sake.cakum_pakum.rest.models.blogpost.BlogPostResponse;
import ba.sake.cakum_pakum.rest.models.blogpost.CreateBlogPostRequest;

@Mapper
public interface BlogPostMapper {

    BlogPostMapper INSTANCE = Mappers.getMapper(BlogPostMapper.class);

    BlogPostResponse entity2Response(BlogPostEntity entity);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "comments", ignore = true)
    BlogPostEntity createRequest2Entity(CreateBlogPostRequest request);
}
