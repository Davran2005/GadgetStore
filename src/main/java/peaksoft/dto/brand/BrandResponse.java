package peaksoft.dto.brand;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@Builder
public class BrandResponse {
    private Long id;
    private String brandName;
    private String image;

    public BrandResponse(Long id, String brandName, String image) {
        this.id = id;
        this.brandName = brandName;
        this.image = image;
    }
}
