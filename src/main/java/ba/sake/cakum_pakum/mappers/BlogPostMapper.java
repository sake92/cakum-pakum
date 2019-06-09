package ba.sake.cakum_pakum.mappers;

import org.springframework.stereotype.Component;
import ba.sake.cakum_pakum.rdb.models.BlogPostEntity;
import ba.sake.cakum_pakum.rest.models.blogpost.BlogPostResponse;
import ba.sake.cakum_pakum.rest.models.blogpost.CreateBlogPostRequest;

@Component
public class BlogPostMapper {

    public BlogPostResponse entity2Response(BlogPostEntity entity) {
        BlogPostResponse response = new BlogPostResponse();
        response.setId(entity.getId());
        response.setContent(entity.getContent());
        return response;
    }

    public BlogPostEntity createRequest2Entity(CreateBlogPostRequest request) {
        BlogPostEntity entity = new BlogPostEntity();
        entity.setContent(request.getContent());
        return entity;
    }
}
