package peaksoft.dto.basket;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
@NoArgsConstructor
@Builder
public class BasketResponse {
    private  Long id;
    private String name;
    private int amount;
   private int sum;

    public BasketResponse(Long id, String name, int amount, int sum) {
        this.id = id;
        this.name = name;
        this.amount = amount;
        this.sum = sum;
    }
}
