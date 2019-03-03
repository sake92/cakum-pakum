package ba.sake.cakum_pakum.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ba.sake.cakum_pakum.dto.comment.CommentDto;
import ba.sake.cakum_pakum.dto.comment.CreateCommentDto;
import ba.sake.cakum_pakum.mapper.CommentMapper;
import ba.sake.cakum_pakum.model.BlogPost;
import ba.sake.cakum_pakum.model.Comment;
import ba.sake.cakum_pakum.repository.BlogPostRepository;
import ba.sake.cakum_pakum.repository.CommentRepository;
import ba.sake.cakum_pakum.service.CommentService;
import ba.sake.cakum_pakum.utils.ExceptionUtils;

@Service
@Transactional
public class CommentServiceImpl implements CommentService {

    @Autowired
    private BlogPostRepository blogPostRepository;
    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private CommentMapper commentMapper;
    @Autowired
    private ExceptionUtils exceptionUtils;

    @Override
    public CommentDto create(Long blogPostId, CreateCommentDto dto) {

        BlogPost blogPost = findBlogPostById(blogPostId);
        Comment c = commentMapper.createDto2Entity(dto);
        c.setBlogPost(blogPost);
        c = commentRepository.save(c);
        blogPost.getComments().add(c);
        return commentMapper.entity2Dto(c);
    }

    @Override
    public CommentDto findById(Long id) {

        Optional<Comment> maybeComment = commentRepository.findById(id);
        return maybeComment.map(commentMapper::entity2Dto)
                .orElseThrow(() -> exceptionUtils.notFound("Comment", id));
    }

    @Override
    public List<CommentDto> findByBlogPostId(Long blogPostId) {

        BlogPost blogPost = findBlogPostById(blogPostId);
        return commentRepository.findByBlogPost(blogPost).stream().map(commentMapper::entity2Dto)
                .collect(Collectors.toList());
    }

    /* helpers */
    private BlogPost findBlogPostById(Long blogPostId) {

        Optional<BlogPost> maybeBlogPost = blogPostRepository.findById(blogPostId);
        return maybeBlogPost.orElseThrow(() -> exceptionUtils.notFound("Blog post", blogPostId));
    }

}
