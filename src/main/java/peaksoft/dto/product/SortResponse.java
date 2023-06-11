package peaksoft.dto.product;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@NoArgsConstructor
@Builder
public class SortResponse {
    private Long id;
    private String name;
    private int price;
    private List<String> images;
    private String characteristic;
    private Boolean isFavorite;
    private String madeIn;

    public SortResponse(Long id, String name, int price, List<String> images, String characteristic, Boolean isFavorite, String madeIn) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.images = images;
        this.characteristic = characteristic;
        this.isFavorite = isFavorite;
        this.madeIn = madeIn;
    }
}
