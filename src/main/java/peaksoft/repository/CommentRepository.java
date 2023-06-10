package peaksoft.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import peaksoft.dto.comment.CommentResponse;
import peaksoft.dto.user.UserResponse;
import peaksoft.entity.Comment;

import java.util.List;
import java.util.Optional;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    @Query("select new peaksoft.dto.comment.CommentResponse(c.id,c.comment,c.createDate) from Comment c")
    List<CommentResponse> getAllComment();
    Optional<CommentResponse> getCommentById(Long id);

}