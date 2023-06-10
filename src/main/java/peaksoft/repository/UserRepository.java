package peaksoft.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import peaksoft.dto.user.UserResponse;
import peaksoft.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    @Query("select new peaksoft.dto.user.UserResponse(u.id,u.firstName,u.lastName,u.email,u.password,u.createdDate,u.updateDate,u.role) from User u")
    public List<UserResponse> getAllUser();
    Optional<UserResponse> getUserById(Long id);


    Optional<User> getUserByEmail(String email);

    boolean existsByEmail(String email);
}