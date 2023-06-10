package peaksoft.service;

import peaksoft.dto.comment.CommentRequest;
import peaksoft.dto.comment.CommentResponse;
import peaksoft.dto.simpl.SimpleResponse;
import peaksoft.dto.user.UserRequest;
import peaksoft.dto.user.UserResponse;

import java.util.List;

public interface CommentService {
    SimpleResponse saveComment(CommentRequest commentRequest);
    List<CommentResponse> getAllComment();
    CommentResponse getCommentById(Long id);
    SimpleResponse updateCommentById(Long id,CommentRequest commentRequest);
    SimpleResponse deleteById(Long id);
}
