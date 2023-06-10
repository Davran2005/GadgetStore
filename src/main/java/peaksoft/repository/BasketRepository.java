package peaksoft.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import peaksoft.dto.basket.BasketResponse;
import peaksoft.dto.user.UserResponse;
import peaksoft.entity.Basket;

import java.util.List;
import java.util.Optional;

public interface BasketRepository extends JpaRepository<Basket, Long> {
    @Query("select b.id,b.user,b.products from User u join u.basket b where u.id=:id")
    List<BasketResponse> getAllBasket(Long id);
    @Query("select s from Basket s where s.id=:id")
    Optional<BasketResponse> getBasketById(Long id);
}