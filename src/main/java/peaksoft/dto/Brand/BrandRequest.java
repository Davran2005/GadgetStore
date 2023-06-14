package peaksoft.dto.Brand;

import lombok.Builder;

@Builder
public record BrandRequest(String brandName,
                           String image) {
    public BrandRequest {
    }
}
