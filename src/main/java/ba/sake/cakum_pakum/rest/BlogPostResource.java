package ba.sake.cakum_pakum.rest;

import javax.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ba.sake.cakum_pakum.mappers.BlogPostMapper;
import ba.sake.cakum_pakum.rdb.models.BlogPostEntity;
import ba.sake.cakum_pakum.rest.models.blogpost.BlogPostResponse;
import ba.sake.cakum_pakum.rest.models.blogpost.CreateBlogPostRequest;
import ba.sake.cakum_pakum.services.BlogPostService;
import lombok.RequiredArgsConstructor;

@RequestMapping("/posts")
@RestController
@RequiredArgsConstructor
public class BlogPostResource {

    private final BlogPostService blogPostService;

    @PostMapping
    public BlogPostResponse create(
            @Valid @RequestBody CreateBlogPostRequest createBlogPostRequest) {

        var newBlogPost = BlogPostMapper.INSTANCE.createRequest2Entity(createBlogPostRequest);
        var createdBlogPost = blogPostService.create(newBlogPost);
        return BlogPostMapper.INSTANCE.entity2Response(createdBlogPost);
    }

    @GetMapping("/search")
    public Page<BlogPostEntity> search(Pageable pageable, @RequestParam String content) {
        
        return blogPostService.search(pageable, content);
    }

    @GetMapping
    public Page<BlogPostResponse> findAll(Pageable pageable) {

        return blogPostService.findAll(pageable).map(BlogPostMapper.INSTANCE::entity2Response);
    }

    @GetMapping("/{postId}")
    public BlogPostResponse findById(@PathVariable Long postId) {

        var blogPost = blogPostService.findById(postId);
        return BlogPostMapper.INSTANCE.entity2Response(blogPost);
    }

}
