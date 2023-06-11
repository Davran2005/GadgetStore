package peaksoft.service.impl;

import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import peaksoft.config.JwtService;
import peaksoft.dto.AuthenticationResponse;
import peaksoft.dto.SignInRequest;
import peaksoft.dto.SignUpRequest;
import peaksoft.dto.simpl.SimpleResponse;
import peaksoft.dto.user.UserRequest;
import peaksoft.dto.user.UserResponse;
import peaksoft.entity.User;
import peaksoft.enums.Role;
import peaksoft.repository.UserRepository;
import peaksoft.service.UserService;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;


@Service
@Transactional
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;

    @Override
    public AuthenticationResponse signUp(SignUpRequest signUpRequest) {
        if (userRepository.existsByEmail(signUpRequest.getEmail())) {
            throw new EntityExistsException(String.format(
                    "User with email: %s already exists!", signUpRequest.getEmail()));
        }

        User user = User.builder()
                .firstName(signUpRequest.getFirstName())
                .lastName(signUpRequest.getLastName())
                .email(signUpRequest.getEmail())
                .password(passwordEncoder.encode(signUpRequest.getPassword()))
                .role(signUpRequest.getRole())
                .build();
        userRepository.save(user);

        String jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse
                .builder()
                .token(jwtToken)
                .email(user.getEmail())
                .role(user.getRole())
                .build();
    }

    @Override
    public AuthenticationResponse signIn(SignInRequest signInRequest) {
        User user = userRepository.getUserByEmail(signInRequest.getEmail())
                .orElseThrow(() -> new EntityNotFoundException(
                        "USer with email: " + signInRequest.getEmail() + " not found"
                ));

        if (signInRequest.getEmail().isBlank()) {
            throw new BadCredentialsException("Email doesn't exist!");
        }

        if (!passwordEncoder.matches(signInRequest.getPassword(), user.getPassword())) {
            throw new BadCredentialsException("Incorrect password!");
        }

        String jwtToken = jwtService.generateToken(user);

        return AuthenticationResponse
                .builder()
                .email(user.getEmail())
                .role(user.getRole())
                .token(jwtToken)
                .build();
    }

        @Override
    public List<UserResponse> getAllUser() {
        return userRepository.getAllUser();
    }

    @Override
    public UserResponse getUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        return userRepository.getUserEmail(email).orElseThrow(() -> new NoSuchElementException("User email: %s not found".formatted(email)));

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
