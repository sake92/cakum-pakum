package ba.sake.cakum_pakum.rdb.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ba.sake.cakum_pakum.rdb.models.BlogPostEntity;
import ba.sake.cakum_pakum.rdb.models.CommentEntity;

@Repository
public interface CommentRepository extends JpaRepository<CommentEntity, Long> {

    Page<CommentEntity> findByBlogPost(BlogPostEntity blogPost, Pageable pageable);
}
