package peaksoft.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@Builder
public class FavoriteRequest {
    private Long userId;
    private Long productId;
}
