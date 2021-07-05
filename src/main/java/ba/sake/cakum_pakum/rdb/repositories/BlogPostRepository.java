package ba.sake.cakum_pakum.rdb.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;
import ba.sake.cakum_pakum.rdb.models.BlogPostEntity;
import ba.sake.cakum_pakum.rdb.models.QBlogPostEntity;

@Repository
public interface BlogPostRepository
        extends JpaRepository<BlogPostEntity, Long>, QuerydslPredicateExecutor<BlogPostEntity> {

    BlogPostEntity findOneByContent(String content);

    default Page<BlogPostEntity> search(Pageable pageable, String content) {
        
        var blogPost = QBlogPostEntity.blogPostEntity;
        var predicate = blogPost.content.likeIgnoreCase("%" + content + "%");
        return this.findAll(predicate, pageable);
    }
}
