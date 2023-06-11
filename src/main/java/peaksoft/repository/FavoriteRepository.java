package peaksoft.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import peaksoft.dto.favorite.FavoriteResponse;
import peaksoft.dto.user.UserResponse;
import peaksoft.entity.Favorite;
import peaksoft.entity.Product;
import peaksoft.entity.User;

import java.util.List;
import java.util.Optional;

public interface FavoriteRepository extends JpaRepository<Favorite, Long> {
    @Query("select f.id,f.user,f.product from Favorite f")
    List<FavoriteResponse> getAllFavorite();
    @Query("select f from Favorite f where f.id = :id")
    Optional<FavoriteResponse> getFavoritesById(Long id);
    void deleteByUserAndProduct(User user, Product product);
    @Query( "SELECT fp.product FROM Favorite fp join fp.user u where u.email= :email")
    FavoriteResponse getFavoriteByProductAndUser(String email);
}