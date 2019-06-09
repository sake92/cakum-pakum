package ba.sake.cakum_pakum.mapper;

import org.springframework.stereotype.Component;
import ba.sake.cakum_pakum.model.Comment;
import ba.sake.cakum_pakum.rest.models.comment.CommentDto;
import ba.sake.cakum_pakum.rest.models.comment.CreateCommentDto;

@Component
public class CommentMapper {

    public CommentDto entity2Dto(Comment entity) {
        CommentDto dto = new CommentDto();
        dto.setId(entity.getId());
        dto.setContent(entity.getContent());
        return dto;
    }

    public Comment createDto2Entity(CreateCommentDto dto) {
        Comment entity = new Comment();
        entity.setContent(dto.getContent());
        return entity;
    }
}
