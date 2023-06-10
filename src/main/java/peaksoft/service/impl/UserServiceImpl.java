package peaksoft.service.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import peaksoft.dto.simpl.SimpleResponse;
import peaksoft.dto.user.UserRequest;
import peaksoft.dto.user.UserResponse;
import peaksoft.entity.User;
import peaksoft.enums.Role;
import peaksoft.repository.UserRepository;
import peaksoft.service.UserService;

import java.time.ZonedDateTime;
import java.util.List;


@Service
@Transactional
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    @Override
    public SimpleResponse saveUser(UserRequest userRequest) {
        User user = new User();
        user.setFirstName(user.getFirstName());
        user.setLastName(user.getLastName());
        user.setEmail(user.getEmail());
        user.setPassword(user.getPassword());
        user.setCreatedDate(ZonedDateTime.now());
        user.setUpdateDate(null);
        user.setRole(Role.USER);
        return SimpleResponse.builder()
                .status(HttpStatus.OK)
                .massage("Успешно")
                .build();
    }

    @Override
    public List<UserResponse> getAllUser() {
        return userRepository.getAllUser();
    }

    @Override
    public UserResponse getUserById(Long id) {
        return userRepository.getUserById(id).orElseThrow(()->new NullPointerException("User with id: " + id + "is not found!"));
    }

    @Override
    public SimpleResponse updateUserById(Long id, UserRequest userRequest) {
        User user = userRepository.findById(id).orElseThrow(() -> new NullPointerException("User with id: " + id + "is not found!"));
        user.setFirstName(user.getFirstName());
        user.setLastName(user.getLastName());
        user.setEmail(user.getEmail());
        user.setPassword(user.getPassword());
        user.setUpdateDate(ZonedDateTime.now());
        user.setRole(Role.USER);
        return SimpleResponse.builder()
                .status(HttpStatus.OK)
                .massage("Успешно")
                .build();
    }


    @Override
    public SimpleResponse deleteById(Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new NullPointerException("User with id: " + id + "is not found!"));
userRepository.delete(user);
        return SimpleResponse.builder()
                .status(HttpStatus.OK)
                .massage("Успешно")
                .build();
    }
}
