package peaksoft.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import peaksoft.dto.product.ProductResponse;
import peaksoft.entity.Product;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query("select new peaksoft.dto.product.ProductResponse(p.id,p.name,p.images,p.characteristic,p.isFavorite,p.madeIn) from Product p")
    List<ProductResponse> getAllProduct();
Optional<ProductResponse> getProductsById(Long id);

    Optional<Product> getProducts1ById(Long id);
}