package peaksoft.service;

import peaksoft.dto.Comment.CommentRequest;
import peaksoft.dto.Comment.CommentResponse;
import peaksoft.dto.SimpleResponse;


import java.util.List;

public interface CommentService {
    List<CommentResponse> getAllComments();
    SimpleResponse saveComment(CommentRequest commentRequest, Long userId, Long productId);
    SimpleResponse deleteCommentById(Long id);
    SimpleResponse updateComment(Long id,CommentRequest commentRequest);
}
