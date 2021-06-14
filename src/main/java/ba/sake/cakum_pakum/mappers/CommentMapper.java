package ba.sake.cakum_pakum.mappers;

import org.springframework.stereotype.Component;
import ba.sake.cakum_pakum.rdb.models.CommentEntity;
import ba.sake.cakum_pakum.rest.models.comment.CommentResponse;
import ba.sake.cakum_pakum.rest.models.comment.CreateCommentRequest;

@Component
public class CommentMapper {

    public CommentResponse entity2Response(CommentEntity entity) {
        var response = new CommentResponse();
        response.setId(entity.getId());
        response.setContent(entity.getContent());
        return response;
    }

    public CommentEntity createRequest2Entity(CreateCommentRequest request) {
        var entity = new CommentEntity();
        entity.setContent(request.getContent());
        return entity;
    }
}
