package ba.sake.cakum_pakum.service.impls;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ba.sake.cakum_pakum.mappers.CommentMapper;
import ba.sake.cakum_pakum.rdb.models.BlogPostEntity;
import ba.sake.cakum_pakum.rdb.models.CommentEntity;
import ba.sake.cakum_pakum.rdb.repositories.BlogPostRdbRepository;
import ba.sake.cakum_pakum.rdb.repositories.CommentRdbRepository;
import ba.sake.cakum_pakum.rest.models.comment.CommentResponse;
import ba.sake.cakum_pakum.rest.models.comment.CreateCommentRequest;
import ba.sake.cakum_pakum.service.CommentService;
import ba.sake.cakum_pakum.utils.ExceptionUtils;

@Service
@Transactional
public class CommentServiceImpl implements CommentService {

    @Autowired
    private BlogPostRdbRepository blogPostRepository;
    @Autowired
    private CommentRdbRepository commentRepository;
    @Autowired
    private CommentMapper commentMapper;
    @Autowired
    private ExceptionUtils exceptionUtils;

    @Override
    public CommentResponse create(Long blogPostId, CreateCommentRequest createCommentRequest) {

        BlogPostEntity blogPost = findBlogPostById(blogPostId);
        CommentEntity c = commentMapper.createRequest2Entity(createCommentRequest);
        c.setBlogPost(blogPost);
        c = commentRepository.save(c);
        blogPost.getComments().add(c);
        return commentMapper.entity2Response(c);
    }

    @Override
    public CommentResponse findById(Long id) {

        Optional<CommentEntity> maybeComment = commentRepository.findById(id);
        return maybeComment.map(commentMapper::entity2Response)
                .orElseThrow(() -> exceptionUtils.notFound("Comment", id));
    }

    @Override
    public List<CommentResponse> findByBlogPostId(Long blogPostId) {

        BlogPostEntity blogPost = findBlogPostById(blogPostId);
        return commentRepository.findByBlogPost(blogPost).stream()
                .map(commentMapper::entity2Response).collect(Collectors.toList());
    }

    /* helpers */
    private BlogPostEntity findBlogPostById(Long blogPostId) {

        Optional<BlogPostEntity> maybeBlogPost = blogPostRepository.findById(blogPostId);
        return maybeBlogPost.orElseThrow(() -> exceptionUtils.notFound("Blog post", blogPostId));
    }

}
