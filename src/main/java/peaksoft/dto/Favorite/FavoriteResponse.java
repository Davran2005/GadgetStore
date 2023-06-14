package peaksoft.dto.Favorite;

import lombok.Builder;

@Builder
public record FavoriteResponse(Long id,
                               String userName,
                               String productName) {
    public FavoriteResponse {
    }
}
