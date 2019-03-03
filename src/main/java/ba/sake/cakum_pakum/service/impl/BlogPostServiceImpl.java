package ba.sake.cakum_pakum.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ba.sake.cakum_pakum.dto.blogpost.BlogPostDto;
import ba.sake.cakum_pakum.dto.blogpost.CreateBlogPostDto;
import ba.sake.cakum_pakum.mapper.BlogPostMapper;
import ba.sake.cakum_pakum.model.BlogPost;
import ba.sake.cakum_pakum.repository.BlogPostRepository;
import ba.sake.cakum_pakum.service.BlogPostService;
import ba.sake.cakum_pakum.utils.ExceptionUtils;

@Service
@Transactional
public class BlogPostServiceImpl implements BlogPostService {

    @Autowired
    private BlogPostRepository blogPostRepository;
    @Autowired
    private BlogPostMapper blogPostMapper;
    @Autowired
    private ExceptionUtils exceptionUtils;

    @Override
    public BlogPostDto create(CreateBlogPostDto dto) {
        BlogPost entity = blogPostMapper.createDto2Entity(dto);
        checkUnique(dto.getContent());
        entity = blogPostRepository.save(entity);
        return blogPostMapper.entity2Dto(entity);
    }

    @Override
    public List<BlogPostDto> findAll() {
        return blogPostRepository.findAll().stream().map(blogPostMapper::entity2Dto)
                .collect(Collectors.toList());
    }

    @Override
    public BlogPostDto findById(Long id) {
        Optional<BlogPost> maybeBlogPost = blogPostRepository.findById(id);
        return maybeBlogPost.map(blogPostMapper::entity2Dto)
                .orElseThrow(() -> exceptionUtils.notFound("Blog post", id));
    }

    private void checkUnique(String content) {
        BlogPost existingBlogPost = blogPostRepository.findOneByContent(content);
        if (existingBlogPost != null) {
            throw exceptionUtils.alreadyExists("Blog post", "content", content);
        }
    }

}
