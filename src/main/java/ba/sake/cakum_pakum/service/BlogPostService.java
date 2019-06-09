package ba.sake.cakum_pakum.service;

import java.util.List;
import ba.sake.cakum_pakum.rest.models.blogpost.BlogPostDto;
import ba.sake.cakum_pakum.rest.models.blogpost.CreateBlogPostDto;

public interface BlogPostService {

    BlogPostDto create(CreateBlogPostDto dto);

    List<BlogPostDto> findAll();

    BlogPostDto findById(Long id);

}