package peaksoft.service;

import peaksoft.dto.Brand.BrandRequest;
import peaksoft.dto.Brand.BrandResponse;
import peaksoft.dto.SimpleResponse;


import java.util.List;

public interface BrandService {
    List<BrandResponse> getAllBrands();
    SimpleResponse saveBrand(BrandRequest brandRequest);
    SimpleResponse updateBrandById(Long id, BrandRequest brandRequest);
    BrandResponse getBrandById(Long id);
    SimpleResponse deleteBrandById(Long id);
    SimpleResponse assignProductToBrand(Long productId,Long brandId);
}
