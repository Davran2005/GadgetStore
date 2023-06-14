package peaksoft.dto.Favorite;

import lombok.Builder;

@Builder
public record FavoriteRequest(Long userId,
                              Long productId) {
    public FavoriteRequest {
    }
}
