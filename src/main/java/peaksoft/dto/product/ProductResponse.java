package peaksoft.dto.product;
import lombok.*;

import java.util.List;
@Setter
@Getter
@NoArgsConstructor
@Builder
public class    ProductResponse {
    private Long id;
    private String name;
    private int price;
    private List<String> images;
    private String characteristic;
    private Boolean isFavorite;
    private String madeIn;

    public ProductResponse(Long id, String name, int price, List<String> images, String characteristic, Boolean isFavorite, String madeIn) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.images = images;
        this.characteristic = characteristic;
        this.isFavorite = isFavorite;
        this.madeIn = madeIn;
    }
}
