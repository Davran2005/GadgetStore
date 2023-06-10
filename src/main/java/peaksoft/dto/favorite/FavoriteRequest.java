package peaksoft.dto.favorite;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@Builder
public class FavoriteRequest {
    private Long productId;
    private Long userId;


}
