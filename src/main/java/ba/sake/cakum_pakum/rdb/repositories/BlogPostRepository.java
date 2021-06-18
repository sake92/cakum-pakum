package ba.sake.cakum_pakum.rdb.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;
import ba.sake.cakum_pakum.rdb.models.BlogPostEntity;

@Repository
public interface BlogPostRepository
        extends JpaRepository<BlogPostEntity, Long>, QuerydslPredicateExecutor<BlogPostEntity> {

    BlogPostEntity findOneByContent(String content);
}
