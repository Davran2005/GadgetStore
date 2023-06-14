package peaksoft.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import peaksoft.dto.Product.AllProductResponse;

import peaksoft.entity.Favorite;
import peaksoft.entity.Product;
import peaksoft.enums.Category;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query("select new peaksoft.dto.Product.AllProductResponse(p.id,p.name,p.price,p.images,p.characteristic,p.isFavorite,p.madeIn,p.category) from Product p " +
            "where p.category=:category and p.price<=:price order by p.price asc")
    List<AllProductResponse> getAllProduct(Category category, int price);

//    @Query ("select c.comment from Product p join p.comments c where p.id=:id")
//    List<String> getAllProductComments(Long id);
//
//    @Query ("select f from Product p join p.favorites f where p.id=:id")
//    List<Favorite> getAllProductFavorites(Long id);
}