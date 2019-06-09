package ba.sake.cakum_pakum.service.impls;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ba.sake.cakum_pakum.mappers.BlogPostMapper;
import ba.sake.cakum_pakum.rdb.models.BlogPostEntity;
import ba.sake.cakum_pakum.rdb.repositories.BlogPostRdbRepository;
import ba.sake.cakum_pakum.rest.models.blogpost.BlogPostResponse;
import ba.sake.cakum_pakum.rest.models.blogpost.CreateBlogPostRequest;
import ba.sake.cakum_pakum.service.BlogPostService;
import ba.sake.cakum_pakum.utils.ExceptionUtils;

@Service
@Transactional
public class BlogPostServiceImpl implements BlogPostService {

    @Autowired
    private BlogPostRdbRepository blogPostRepository;
    @Autowired
    private BlogPostMapper blogPostMapper;
    @Autowired
    private ExceptionUtils exceptionUtils;

    @Override
    public BlogPostResponse create(CreateBlogPostRequest createBlogPostRequest) {
        BlogPostEntity blogPostEntity = blogPostMapper.createRequest2Entity(createBlogPostRequest);
        checkUnique(createBlogPostRequest.getContent());
        blogPostEntity = blogPostRepository.save(blogPostEntity);
        return blogPostMapper.entity2Response(blogPostEntity);
    }

    @Override
    public List<BlogPostResponse> findAll() {
        return blogPostRepository.findAll().stream().map(blogPostMapper::entity2Response)
                .collect(Collectors.toList());
    }

    @Override
    public BlogPostResponse findById(Long id) {
        Optional<BlogPostEntity> maybeBlogPost = blogPostRepository.findById(id);
        return maybeBlogPost.map(blogPostMapper::entity2Response)
                .orElseThrow(() -> exceptionUtils.notFound("Blog post", id));
    }

    private void checkUnique(String content) {
        BlogPostEntity existingBlogPost = blogPostRepository.findOneByContent(content);
        if (existingBlogPost != null) {
            throw exceptionUtils.alreadyExists("Blog post", "content", content);
        }
    }

}
