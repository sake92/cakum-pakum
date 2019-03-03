package ba.sake.cakum_pakum.mapper;

import org.springframework.stereotype.Component;
import ba.sake.cakum_pakum.dto.blogpost.BlogPostDto;
import ba.sake.cakum_pakum.dto.blogpost.CreateBlogPostDto;
import ba.sake.cakum_pakum.model.BlogPost;

@Component
public class BlogPostMapper {

    public BlogPostDto entity2Dto(BlogPost entity) {
        BlogPostDto dto = new BlogPostDto();
        dto.setId(entity.getId());
        dto.setContent(entity.getContent());
        return dto;
    }

    public BlogPost createDto2Entity(CreateBlogPostDto dto) {
        BlogPost entity = new BlogPost();
        entity.setContent(dto.getContent());
        return entity;
    }
}
