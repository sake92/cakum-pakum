package ba.sake.cakum_pakum.service;

import java.util.List;
import ba.sake.cakum_pakum.rest.models.comment.CommentResponse;
import ba.sake.cakum_pakum.rest.models.comment.CreateCommentRequest;

public interface CommentService {

    CommentResponse create(Long blogPostId, CreateCommentRequest createCommentRequest);

    CommentResponse findById(Long id);

    List<CommentResponse> findByBlogPostId(Long blogPostId);
}
