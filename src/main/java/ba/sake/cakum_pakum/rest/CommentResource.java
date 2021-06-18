package ba.sake.cakum_pakum.rest;

import javax.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ba.sake.cakum_pakum.mappers.CommentMapper;
import ba.sake.cakum_pakum.rest.models.comment.CommentResponse;
import ba.sake.cakum_pakum.rest.models.comment.CreateCommentRequest;
import ba.sake.cakum_pakum.services.CommentService;
import lombok.RequiredArgsConstructor;

@RequestMapping("/posts/{postId}/comments")
@RestController
@RequiredArgsConstructor
public class CommentResource {

    private final CommentService commentService;

    @GetMapping("/{commentId}")
    public CommentResponse findById(@PathVariable Long postId, @PathVariable Long commentId) {

        var comment = commentService.findById(postId, commentId);
        return CommentMapper.INSTANCE.entity2Response(comment);
    }

    @GetMapping
    public Page<CommentResponse> findByBlogPostId(@PathVariable Long postId, Pageable pageable) {

        return commentService.findByBlogPostId(postId, pageable)
                .map(CommentMapper.INSTANCE::entity2Response);
    }

    @PostMapping
    public CommentResponse addComment(@PathVariable Long postId,
            @Valid @RequestBody CreateCommentRequest createCommentRequest) {

        var newComment = CommentMapper.INSTANCE.createRequest2Entity(createCommentRequest);
        var createdComment = commentService.create(postId, newComment);
        return CommentMapper.INSTANCE.entity2Response(createdComment);
    }

}
