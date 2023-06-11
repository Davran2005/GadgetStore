package peaksoft.dto.basket;

import lombok.*;

import java.math.BigDecimal;
@Setter
@Getter
@NoArgsConstructor

@Builder
public class AllBasketResponse {
    private String userEmail;
    private int productAmount;
    private int price;

    public AllBasketResponse(String userEmail, int productAmount, int price) {
        this.userEmail = userEmail;
        this.productAmount = productAmount;
        this.price = price;
    }
}
