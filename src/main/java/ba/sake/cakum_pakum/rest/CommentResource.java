package ba.sake.cakum_pakum.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ba.sake.cakum_pakum.mappers.CommentMapper;
import ba.sake.cakum_pakum.rest.models.comment.CommentResponse;
import ba.sake.cakum_pakum.services.CommentService;

@RestController
@RequestMapping("/comments")
public class CommentResource {

    private CommentService commentService;

    private CommentMapper commentMapper;

    public CommentResource(CommentService commentService, CommentMapper commentMapper) {
        this.commentService = commentService;
        this.commentMapper = commentMapper;
    }

    @GetMapping("/{id}")
    public CommentResponse findById(@PathVariable Long id) {
        var comment = commentService.findById(id);
        return commentMapper.entity2Response(comment);
    }

}
