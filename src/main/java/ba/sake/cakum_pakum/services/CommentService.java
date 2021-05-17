package ba.sake.cakum_pakum.services;

import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ba.sake.cakum_pakum.rdb.models.BlogPostEntity;
import ba.sake.cakum_pakum.rdb.models.CommentEntity;
import ba.sake.cakum_pakum.rdb.repositories.BlogPostRdbRepository;
import ba.sake.cakum_pakum.rdb.repositories.CommentRdbRepository;
import ba.sake.cakum_pakum.utils.ExceptionUtils;

@Service
@Transactional
public class CommentService {

    private BlogPostRdbRepository blogPostRepository;
    private CommentRdbRepository commentRepository;
    private ExceptionUtils exceptionUtils;

    public CommentService(BlogPostRdbRepository blogPostRepository,
            CommentRdbRepository commentRepository, ExceptionUtils exceptionUtils) {
        this.blogPostRepository = blogPostRepository;
        this.commentRepository = commentRepository;
        this.exceptionUtils = exceptionUtils;
    }

    public CommentEntity create(Long blogPostId, CommentEntity comment) {

        var blogPost = findBlogPostById(blogPostId);
        comment.setBlogPost(blogPost);
        comment = commentRepository.save(comment);
        return comment;
    }

    public CommentEntity findById(Long id) {

        Optional<CommentEntity> maybeComment = commentRepository.findById(id);
        return maybeComment.orElseThrow(() -> exceptionUtils.notFound("Comment", id));
    }

    public Page<CommentEntity> findByBlogPostId(Long blogPostId) {

        var blogPost = findBlogPostById(blogPostId);
        return commentRepository.findByBlogPost(blogPost, Pageable.unpaged());
    }

    private BlogPostEntity findBlogPostById(Long blogPostId) {

        Optional<BlogPostEntity> maybeBlogPost = blogPostRepository.findById(blogPostId);
        return maybeBlogPost.orElseThrow(() -> exceptionUtils.notFound("Blog post", blogPostId));
    }

}
