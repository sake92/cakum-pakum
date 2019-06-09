package ba.sake.cakum_pakum.rdb.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ba.sake.cakum_pakum.rdb.models.BlogPostEntity;
import ba.sake.cakum_pakum.rdb.models.CommentEntity;

@Repository
public interface CommentRdbRepository extends JpaRepository<CommentEntity, Long> {

    List<CommentEntity> findByBlogPost(BlogPostEntity blogPost);
}
