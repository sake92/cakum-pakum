package ba.sake.cakum_pakum.services;

import javax.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ba.sake.cakum_pakum.rdb.models.BlogPostEntity;
import ba.sake.cakum_pakum.rdb.models.CommentEntity;
import ba.sake.cakum_pakum.rdb.repositories.BlogPostRepository;
import ba.sake.cakum_pakum.rdb.repositories.CommentRepository;
import ba.sake.cakum_pakum.rest.exceptions.NotFoundProblem;
import lombok.RequiredArgsConstructor;

@Transactional
@Service
@RequiredArgsConstructor
public class CommentService {

    private final BlogPostRepository blogPostRepository;
    private final CommentRepository commentRepository;

    public CommentEntity create(Long blogPostId, CommentEntity comment) {

        var blogPost = findBlogPostById(blogPostId);
        comment.setBlogPost(blogPost);
        comment = commentRepository.save(comment);
        return comment;
    }

    public CommentEntity findById(Long id) {

        var maybeComment = commentRepository.findById(id);
        return maybeComment.orElseThrow(() -> new NotFoundProblem("Comment", id));
    }

    public Page<CommentEntity> findByBlogPostId(Long blogPostId, Pageable pageable) {

        var blogPost = findBlogPostById(blogPostId);
        return commentRepository.findByBlogPost(blogPost, pageable);
    }

    private BlogPostEntity findBlogPostById(Long blogPostId) {

        var maybeBlogPost = blogPostRepository.findById(blogPostId);
        return maybeBlogPost.orElseThrow(() -> new NotFoundProblem("Blog post", blogPostId));
    }

}
