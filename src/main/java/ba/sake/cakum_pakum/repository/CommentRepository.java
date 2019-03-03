package ba.sake.cakum_pakum.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ba.sake.cakum_pakum.model.BlogPost;
import ba.sake.cakum_pakum.model.Comment;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

    
    
    List<Comment> findByBlogPost(BlogPost blogPost);
}
