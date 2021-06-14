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

    private final BlogPostMapper blogPostMapper;
    private final CommentMapper commentMapper;

    @PostMapping
    public BlogPostResponse create(
            @Valid @RequestBody CreateBlogPostRequest createBlogPostRequest) {
        var newBlogPost = blogPostMapper.createRequest2Entity(createBlogPostRequest);
        var createdBlogPost = blogPostService.create(newBlogPost);
        return blogPostMapper.entity2Response(createdBlogPost);
    }

    @GetMapping
    public Page<BlogPostResponse> findAll() {
        return blogPostService.findAll().map(blogPostMapper::entity2Response);
    }

    @GetMapping("/{id}")
    public BlogPostResponse findById(@PathVariable Long id) {
        var blogPost = blogPostService.findById(id);
        return blogPostMapper.entity2Response(blogPost);
    }

    /* comments */
    @GetMapping("/{blogPostId}/comments")
    public Page<CommentResponse> findCommentsByBlogPostId(@PathVariable Long blogPostId) {
        return commentService.findByBlogPostId(blogPostId).map(commentMapper::entity2Response);
    }

    @PostMapping("/{blogPostId}/comments")
    public CommentResponse addComment(@PathVariable Long blogPostId,
            @Valid @RequestBody CreateCommentRequest createCommentRequest) {
        var newComment = commentMapper.createRequest2Entity(createCommentRequest);
        var createdComment = commentService.create(blogPostId, newComment);
        return commentMapper.entity2Response(createdComment);
    }

}
