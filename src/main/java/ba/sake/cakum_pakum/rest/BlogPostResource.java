package ba.sake.cakum_pakum.rest;

import javax.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ba.sake.cakum_pakum.mappers.BlogPostMapper;
import ba.sake.cakum_pakum.mappers.CommentMapper;
import ba.sake.cakum_pakum.rest.models.blogpost.BlogPostResponse;
import ba.sake.cakum_pakum.rest.models.blogpost.CreateBlogPostRequest;
import ba.sake.cakum_pakum.rest.models.comment.CommentResponse;
import ba.sake.cakum_pakum.rest.models.comment.CreateCommentRequest;
import ba.sake.cakum_pakum.services.BlogPostService;
import ba.sake.cakum_pakum.services.CommentService;
import lombok.RequiredArgsConstructor;

@RequestMapping("/posts")
@RestController
@RequiredArgsConstructor
public class BlogPostResource {

    private final BlogPostService blogPostService;
    private final CommentService commentService;

    @PostMapping
    public BlogPostResponse create(
            @Valid @RequestBody CreateBlogPostRequest createBlogPostRequest) {
        var newBlogPost = BlogPostMapper.INSTANCE.createRequest2Entity(createBlogPostRequest);
        var createdBlogPost = blogPostService.create(newBlogPost);
        return BlogPostMapper.INSTANCE.entity2Response(createdBlogPost);
    }

    @GetMapping
    public Page<BlogPostResponse> findAll() {
        return blogPostService.findAll().map(BlogPostMapper.INSTANCE::entity2Response);
    }

    @GetMapping("/{id}")
    public BlogPostResponse findById(@PathVariable Long id) {
        var blogPost = blogPostService.findById(id);
        return BlogPostMapper.INSTANCE.entity2Response(blogPost);
    }

    /* comments */
    @GetMapping("/{blogPostId}/comments")
    public Page<CommentResponse> findCommentsByBlogPostId(@PathVariable Long blogPostId) {
        return commentService.findByBlogPostId(blogPostId)
                .map(CommentMapper.INSTANCE::entity2Response);
    }

    @PostMapping("/{blogPostId}/comments")
    public CommentResponse addComment(@PathVariable Long blogPostId,
            @Valid @RequestBody CreateCommentRequest createCommentRequest) {
        var newComment = CommentMapper.INSTANCE.createRequest2Entity(createCommentRequest);
        var createdComment = commentService.create(blogPostId, newComment);
        return CommentMapper.INSTANCE.entity2Response(createdComment);
    }

}
