package ba.sake.cakum_pakum.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ba.sake.cakum_pakum.rest.models.comment.CommentDto;
import ba.sake.cakum_pakum.service.CommentService;

@RestController
@RequestMapping("/comments")
public class CommentResource {

    @Autowired
    private CommentService commentService;

    @GetMapping("/{id}")
    public CommentDto findById(@PathVariable Long id) {
        return commentService.findById(id);
    }

}
