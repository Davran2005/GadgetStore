package peaksoft.dto.Basket;

import lombok.Builder;

import java.util.List;
@Builder
public record BasketResponse(Long Id,
                             List<String> productName,
                             String userName) {
}
