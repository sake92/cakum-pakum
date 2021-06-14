package ba.sake.cakum_pakum.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ba.sake.cakum_pakum.mappers.CommentMapper;
import ba.sake.cakum_pakum.rest.models.comment.CommentResponse;
import ba.sake.cakum_pakum.services.CommentService;
import lombok.RequiredArgsConstructor;

@RequestMapping("/comments")
@RestController
@RequiredArgsConstructor
public class CommentResource {

    private final CommentService commentService;

    private final CommentMapper commentMapper;

    @GetMapping("/{id}")
    public CommentResponse findById(@PathVariable Long id) {
        var comment = commentService.findById(id);
        return commentMapper.entity2Response(comment);
    }

}
