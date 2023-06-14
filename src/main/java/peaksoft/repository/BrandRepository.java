package peaksoft.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import peaksoft.dto.Brand.BrandResponse;

import peaksoft.entity.Brand;

import java.util.List;

public interface BrandRepository extends JpaRepository<Brand, Long> {

    @Query("select new peaksoft.dto.Brand.BrandResponse(b.id,b.brandName,b.image) from Brand b")
    List<BrandResponse> getAllBrands();
}