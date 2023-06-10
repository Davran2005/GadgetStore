package peaksoft.service;

import peaksoft.dto.basket.BasketRequest;
import peaksoft.dto.brand.BrandRequest;
import peaksoft.dto.brand.BrandResponse;
import peaksoft.dto.comment.CommentRequest;
import peaksoft.dto.simpl.SimpleResponse;
import peaksoft.dto.user.UserResponse;

import java.util.List;

public interface BrandService {
    SimpleResponse saveBrand(BrandRequest brandRequest);
    List<BrandResponse> getAllBrand();
    BrandResponse getBrandById(Long id);
    SimpleResponse updateBrandById(Long id,BrandRequest brandRequest);
    SimpleResponse deleteById(Long id);
}
