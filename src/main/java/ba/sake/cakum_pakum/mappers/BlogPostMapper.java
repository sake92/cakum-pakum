package ba.sake.cakum_pakum.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import ba.sake.cakum_pakum.rdb.models.BlogPostEntity;
import ba.sake.cakum_pakum.rest.models.blogpost.BlogPostResponse;
import ba.sake.cakum_pakum.rest.models.blogpost.CreateBlogPostRequest;

@Mapper 
public interface BlogPostMapper {
    
    BlogPostMapper INSTANCE = Mappers.getMapper( BlogPostMapper.class );
    
     BlogPostResponse entity2Response(BlogPostEntity entity);
     
     BlogPostEntity createRequest2Entity(CreateBlogPostRequest request);

  /*  public BlogPostResponse entity2Response(BlogPostEntity entity) {
        var response = new BlogPostResponse();
        response.setId(entity.getId());
        response.setContent(entity.getContent());
        return response;
    }

    public BlogPostEntity createRequest2Entity(CreateBlogPostRequest request) {
        var entity = new BlogPostEntity();
        entity.setContent(request.getContent());
        return entity;
    }*/
}
