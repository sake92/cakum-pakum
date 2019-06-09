package ba.sake.cakum_pakum.rest;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ba.sake.cakum_pakum.rest.models.blogpost.BlogPostResponse;
import ba.sake.cakum_pakum.rest.models.blogpost.CreateBlogPostRequest;
import ba.sake.cakum_pakum.rest.models.comment.CommentResponse;
import ba.sake.cakum_pakum.rest.models.comment.CreateCommentRequest;
import ba.sake.cakum_pakum.service.BlogPostService;
import ba.sake.cakum_pakum.service.CommentService;

@RestController
@RequestMapping("/posts")
public class BlogPostResource {

    @Autowired
    private BlogPostService blogPostService;
    @Autowired
    private CommentService commentService;

    @PostMapping
    public BlogPostResponse create(
            @Valid @RequestBody CreateBlogPostRequest createBlogPostRequest) {
        return blogPostService.create(createBlogPostRequest);
    }

    @GetMapping
    public List<BlogPostResponse> findAll() {
        return blogPostService.findAll();
    }

    @GetMapping("/{id}")
    public BlogPostResponse findById(@PathVariable Long id) {
        return blogPostService.findById(id);
    }

    /* comments */
    @GetMapping("/{blogPostId}/comments")
    public List<CommentResponse> findCommentsById(@PathVariable Long blogPostId) {
        return commentService.findByBlogPostId(blogPostId);
    }

    @PostMapping("/{blogPostId}/comments")
    public CommentResponse create(@PathVariable Long blogPostId,
            @Valid @RequestBody CreateCommentRequest createCommentRequest) {
        return commentService.create(blogPostId, createCommentRequest);
    }

}
