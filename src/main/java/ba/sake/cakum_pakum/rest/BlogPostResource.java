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
import ba.sake.cakum_pakum.dto.blogpost.BlogPostDto;
import ba.sake.cakum_pakum.dto.blogpost.CreateBlogPostDto;
import ba.sake.cakum_pakum.dto.comment.CommentDto;
import ba.sake.cakum_pakum.dto.comment.CreateCommentDto;
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
    public BlogPostDto create(@Valid @RequestBody CreateBlogPostDto dto) {
        return blogPostService.create(dto);
    }

    @GetMapping
    public List<BlogPostDto> findAll() {
        return blogPostService.findAll();
    }

    @GetMapping("/{id}")
    public BlogPostDto findById(@PathVariable Long id) {
        return blogPostService.findById(id);
    }

    /* comments */
    @GetMapping("/{blogPostId}/comments")
    public List<CommentDto> findCommentsById(@PathVariable Long blogPostId) {
        return commentService.findByBlogPostId(blogPostId);
    }

    @PostMapping("/{blogPostId}/comments")
    public CommentDto create(@PathVariable Long blogPostId,
            @Valid @RequestBody CreateCommentDto dto) {
        return commentService.create(blogPostId, dto);
    }

}
