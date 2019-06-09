package ba.sake.cakum_pakum.service;

import java.util.List;
import ba.sake.cakum_pakum.rest.models.comment.CommentDto;
import ba.sake.cakum_pakum.rest.models.comment.CreateCommentDto;

public interface CommentService {

    CommentDto create(Long blogPostId, CreateCommentDto dto);

    CommentDto findById(Long id);

    List<CommentDto> findByBlogPostId(Long blogPostId);
}
