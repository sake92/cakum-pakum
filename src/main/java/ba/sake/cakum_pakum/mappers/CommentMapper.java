package ba.sake.cakum_pakum.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import ba.sake.cakum_pakum.rdb.models.CommentEntity;
import ba.sake.cakum_pakum.rest.models.comment.CommentResponse;
import ba.sake.cakum_pakum.rest.models.comment.CreateCommentRequest;

@Mapper
public interface CommentMapper {
    
    CommentMapper INSTANCE = Mappers.getMapper( CommentMapper.class );
    
    CommentResponse entity2Response(CommentEntity entity);
    
    CommentEntity createRequest2Entity(CreateCommentRequest request);

  /*  public CommentResponse entity2Response(CommentEntity entity) {
        var response = new CommentResponse();
        response.setId(entity.getId());
        response.setContent(entity.getContent());
        return response;
    }

    public CommentEntity createRequest2Entity(CreateCommentRequest request) {
        var entity = new CommentEntity();
        entity.setContent(request.getContent());
        return entity;
    }*/
}
