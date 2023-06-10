package peaksoft.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import peaksoft.dto.brand.BrandResponse;
import peaksoft.entity.Brand;

import java.util.List;
import java.util.Optional;

public interface BrandRepository extends JpaRepository<Brand, Long> {
    @Query("select new peaksoft.dto.brand.BrandResponse(b.id,b.brandName,b.image) from Brand b")
    List<BrandResponse> getAllBrand();
    Optional<BrandResponse> getBrandById(Long id);
}