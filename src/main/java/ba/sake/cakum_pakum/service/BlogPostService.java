package ba.sake.cakum_pakum.service;

import java.util.List;
import ba.sake.cakum_pakum.rest.models.blogpost.BlogPostResponse;
import ba.sake.cakum_pakum.rest.models.blogpost.CreateBlogPostRequest;

public interface BlogPostService {

    BlogPostResponse create(CreateBlogPostRequest createBlogPostRequest);

    List<BlogPostResponse> findAll();

    BlogPostResponse findById(Long id);

}
