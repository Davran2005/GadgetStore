package peaksoft.dto.Brand;

import lombok.Builder;

@Builder
public record BrandResponse(Long id,
                            String brandName,
                            String image) {
    public BrandResponse {
    }
}
