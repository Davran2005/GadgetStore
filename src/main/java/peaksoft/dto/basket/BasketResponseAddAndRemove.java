package peaksoft.dto.basket;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@Builder
public class BasketResponseAddAndRemove {
    private Long id;
    private Long productId;
    private Long userId;

    public BasketResponseAddAndRemove(Long id, Long productId, Long userId) {
        this.id = id;
        this.productId = productId;
        this.userId = userId;
    }
}
