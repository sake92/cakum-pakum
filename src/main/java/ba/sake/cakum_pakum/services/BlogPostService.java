package ba.sake.cakum_pakum.services;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ba.sake.cakum_pakum.rdb.models.BlogPostEntity;
import ba.sake.cakum_pakum.rdb.repositories.BlogPostRdbRepository;
import ba.sake.cakum_pakum.utils.ExceptionUtils;

@Service
@Transactional
public class BlogPostService {

    @Autowired
    private BlogPostRdbRepository blogPostRepository;
    @Autowired
    private ExceptionUtils exceptionUtils;

    public BlogPostEntity create(BlogPostEntity blogPost) {
        checkUnique(blogPost.getContent());
        return blogPostRepository.save(blogPost);
    }

    public Page<BlogPostEntity> findAll() {
        return blogPostRepository.findAll(Pageable.unpaged());
    }

    public BlogPostEntity findById(Long id) {
        var maybeBlogPost = blogPostRepository.findById(id);
        return maybeBlogPost.orElseThrow(() -> exceptionUtils.notFound("Blog post", id));
    }

    private void checkUnique(String content) {
        BlogPostEntity existingBlogPost = blogPostRepository.findOneByContent(content);
        if (existingBlogPost != null) {
            throw exceptionUtils.alreadyExists("Blog post", "content", content);
        }
    }

}
