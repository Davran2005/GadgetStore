package peaksoft.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import peaksoft.dto.User.UserResponse;

import peaksoft.entity.Product;
import peaksoft.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
@Query("select new peaksoft.dto.User.UserResponse(u.id,u.firstName,u.lastName,u.email,u.password,u.createdAt,u.updateDate,u.role) from User u")
        List<UserResponse> getAllUsers();
    Optional<User> getUserByEmail(String email);
    boolean existsByEmail(String email);

    @Modifying
    @Query("update Basket b set b.products = :list where b.id=:id")
    void deleteAllBasketsProducts(Long id, List<Product> list);


}