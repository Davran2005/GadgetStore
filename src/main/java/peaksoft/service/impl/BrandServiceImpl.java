package peaksoft.service.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import peaksoft.dto.brand.BrandRequest;
import peaksoft.dto.brand.BrandResponse;
import peaksoft.dto.simpl.SimpleResponse;
import peaksoft.dto.user.UserResponse;
import peaksoft.entity.Brand;
import peaksoft.repository.BrandRepository;
import peaksoft.service.BrandService;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class BrandServiceImpl implements BrandService {
    private final BrandRepository brandRepository;

    @Override
    public SimpleResponse saveBrand(BrandRequest brandRequest) {
        Brand brand = new Brand();
        brand.setBrandName(brandRequest.getBrandName());
        brand.setImage(brandRequest.getImage());
        brandRepository.save(brand);
        return SimpleResponse.builder()
                .status(HttpStatus.OK)
                .massage("Успешно")
                .build();
    }

    @Override
    public List<BrandResponse> getAllBrand() {
        return brandRepository.getAllBrand();
    }

    @Override
    public BrandResponse getBrandById(Long id) {
        return brandRepository.getBrandById(id).orElseThrow(() -> new NullPointerException("Brand with id: " + id + "is not found"));
    }

    @Override
    public SimpleResponse updateBrandById(Long id, BrandRequest brandRequest) {
        Brand brand = brandRepository.findById(id).orElseThrow(() -> new NullPointerException("Brand with id: " + id + "is not found"));
        brand.setBrandName(brandRequest.getBrandName());
        brand.setImage(brandRequest.getImage());
        return SimpleResponse.builder()
                .status(HttpStatus.OK)
                .massage("Успешно")
                .build();
    }

    @Override
    public SimpleResponse deleteById(Long id) {
        Brand brand = brandRepository.findById(id).orElseThrow(() -> new NullPointerException("Brand with id: " + id + "is not found"));
        brandRepository.delete(brand);
        return SimpleResponse.builder()
                .status(HttpStatus.OK)
                .massage("Успешно")
                .build();
    }
}
