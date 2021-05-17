package ba.sake.cakum_pakum.services;

import javax.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ba.sake.cakum_pakum.rdb.models.BlogPostEntity;
import ba.sake.cakum_pakum.rdb.repositories.BlogPostRepository;
import ba.sake.cakum_pakum.rest.exceptions.AlreadyExistsProblem;
import ba.sake.cakum_pakum.rest.exceptions.NotFoundProblem;

@Service
@Transactional
public class BlogPostService {

    private BlogPostRepository blogPostRepository;

    public BlogPostService(BlogPostRepository blogPostRepository) {
        this.blogPostRepository = blogPostRepository;
    }

    public BlogPostEntity create(BlogPostEntity blogPost) {
        checkUnique(blogPost.getContent());
        return blogPostRepository.save(blogPost);
    }

    public Page<BlogPostEntity> findAll() {
        return blogPostRepository.findAll(Pageable.unpaged());
    }

    public BlogPostEntity findById(Long id) {
        var maybeBlogPost = blogPostRepository.findById(id);
        return maybeBlogPost.orElseThrow(() -> new NotFoundProblem("Blog post", id));
    }

    private void checkUnique(String content) {
        var existingBlogPost = blogPostRepository.findOneByContent(content);
        if (existingBlogPost != null) {
            throw new AlreadyExistsProblem("Blog post", "content", content);
        }
    }

}
