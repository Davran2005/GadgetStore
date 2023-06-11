package peaksoft.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import peaksoft.dto.product.ProductResponse;
import peaksoft.dto.product.SortResponse;
import peaksoft.entity.Product;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query("select new peaksoft.dto.product.ProductResponse(p.id,p.name,p.price,p.images,p.characteristic,p.isFavorite,p.madeIn) from Product p")
    List<ProductResponse> getAllProduct();

    Optional<ProductResponse> getProductsById(Long id);



    @Query("select p.id,p.name,p.price,p.images,p.characteristic,p.isFavorite,p.madeIn from Product p where p.category ='LAPTOP'")
    List<ProductResponse> info1();

    @Query("select p.id,p.name,p.price,p.images,p.characteristic,p.isFavorite,p.madeIn from Product p where p.category ='PHONE'")
    List<ProductResponse> info2();

    @Query("select p.id,p.name,p.price,p.images,p.characteristic,p.isFavorite,p.madeIn from Product p where p.category ='HEADPHONES'")
    List<ProductResponse> info3();

    @Query("select p.id,p.name,p.price,p.images,p.characteristic,p.isFavorite,p.madeIn from Product p where p.category =' SMART_WATCH'")
    List<ProductResponse> info4();

    @Query("select p, c  from Product p join p.comments c where p.id =:productId")
    ProductResponse productAndComments(Long productId);
@Query("select  count (p.isFavorite) from Product p where  p.id =:productId")
    ProductResponse productCountLike(Long productId);
}