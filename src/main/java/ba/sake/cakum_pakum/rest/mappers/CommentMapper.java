package ba.sake.cakum_pakum.rest.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import ba.sake.cakum_pakum.rdb.models.CommentEntity;
import ba.sake.cakum_pakum.rest.models.comment.CommentResponse;
import ba.sake.cakum_pakum.rest.models.comment.CreateCommentRequest;

@Mapper
public interface CommentMapper {

    CommentMapper INSTANCE = Mappers.getMapper(CommentMapper.class);

    CommentResponse entity2Response(CommentEntity entity);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "blogPost", ignore = true)
    CommentEntity createRequest2Entity(CreateCommentRequest request);
}
