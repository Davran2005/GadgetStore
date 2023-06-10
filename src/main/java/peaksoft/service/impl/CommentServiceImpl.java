package peaksoft.service.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import peaksoft.dto.comment.CommentRequest;
import peaksoft.dto.comment.CommentResponse;
import peaksoft.dto.simpl.SimpleResponse;
import peaksoft.dto.user.UserResponse;
import peaksoft.entity.Comment;
import peaksoft.repository.CommentRepository;
import peaksoft.service.CommentService;

import java.time.ZonedDateTime;
import java.util.List;
@Service
@Transactional
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {
    private final CommentRepository commentRepository;
    @Override
    public SimpleResponse saveComment(CommentRequest commentRequest) {
            Comment comment = new Comment();
            comment.setComment(commentRequest.getComment());
            comment.setCreateDate(ZonedDateTime.now());
            commentRepository.save(comment);
            return SimpleResponse.builder()
                    .status(HttpStatus.OK)
                    .massage("Успешно")
                    .build();
    }

    @Override
    public List<CommentResponse> getAllComment() {
        return commentRepository.getAllComment();
    }

    @Override
    public CommentResponse getCommentById(Long id) {
        return commentRepository.getCommentById(id).orElseThrow(()-> new NullPointerException("Comment with id: " + id + "is not found!"));
    }

    @Override
    public SimpleResponse updateCommentById(Long id, CommentRequest commentRequest) {
        Comment comment = commentRepository.findById(id).orElseThrow(() -> new NullPointerException("Comment with id: " + id + "is not found!"));
        comment.setComment(commentRequest.getComment());
        return SimpleResponse.builder()
                .status(HttpStatus.OK)
                .massage("Успешно")
                .build();
    }

    @Override
    public SimpleResponse deleteById(Long id) {
        Comment comment = commentRepository.findById(id).orElseThrow(() -> new NullPointerException("Comment with id: " + id + "is not found!"));
        commentRepository.delete(comment);
        return SimpleResponse.builder()
                .status(HttpStatus.OK)
                .massage("Успешно")
                .build();
    }
}
