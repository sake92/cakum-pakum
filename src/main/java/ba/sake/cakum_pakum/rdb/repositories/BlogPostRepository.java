package ba.sake.cakum_pakum.rdb.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ba.sake.cakum_pakum.rdb.models.BlogPostEntity;

@Repository
public interface BlogPostRepository extends JpaRepository<BlogPostEntity, Long> {

    BlogPostEntity findOneByContent(String content);
}
