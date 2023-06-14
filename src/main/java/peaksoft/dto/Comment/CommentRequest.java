package peaksoft.dto.Comment;

import lombok.Builder;

@Builder
public record CommentRequest(String comment) {
    public CommentRequest {
    }
}
