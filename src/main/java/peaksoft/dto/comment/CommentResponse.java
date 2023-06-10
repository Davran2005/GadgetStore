package peaksoft.dto.comment;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.ZonedDateTime;
@Setter
@Getter
@NoArgsConstructor
@Builder
public class CommentResponse {
    private Long id;
    private String comment;
    private ZonedDateTime createDate;

    public CommentResponse(Long id, String comment, ZonedDateTime createDate) {
        this.id = id;
        this.comment = comment;
        this.createDate = createDate;
    }
}
