package peaksoft.dto.basket;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@Builder
public class BasketRequest {
    private Long productId;
    private Long userId;
}
