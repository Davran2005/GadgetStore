package peaksoft.service.serviceImpl;

import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

import peaksoft.exception.BadCredentialException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import peaksoft.config.JWTService;
import peaksoft.dto.Authentication.AdminTokenRequest;
import peaksoft.dto.Authentication.AuthenticationRequest;
import peaksoft.dto.Authentication.AuthenticationResponse;
import peaksoft.dto.Authentication.SignIn;
import peaksoft.entity.Basket;
import peaksoft.entity.User;
import peaksoft.enums.Role;
import peaksoft.exception.NotFoundException;
import peaksoft.repository.BasketRepository;
import peaksoft.repository.UserRepository;
import peaksoft.service.AuthenticationService;

import java.time.ZonedDateTime;

@Service
@Transactional
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {
    private final UserRepository userRepository;
    private final JWTService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final BasketRepository basketRepository;
//    erjan00
    @Override
    public AuthenticationResponse adminToken(AdminTokenRequest adminTokenRequest) {
        User user1 = userRepository.findById(1L).orElseThrow(() -> new UsernameNotFoundException("user with email: 1 is not found!"));
        String token = jwtService.generateToken(user1);
        System.out.println(token);
        return AuthenticationResponse.builder()
                .email(user1.getEmail())
                .token(token)
                .role(user1.getRole().name())
                .build();
    }

    @Override
    public AuthenticationResponse signUp(AuthenticationRequest authenticationRequest) {
        User user = new User();
        user.setFirstName(authenticationRequest.firstName());
        user.setLastName(authenticationRequest.lastName());
        user.setEmail(authenticationRequest.email());
        user.setRole(Role.USER);
        user.setPassword(passwordEncoder.encode(authenticationRequest.password()));
        user.setCreatedAt(ZonedDateTime.now());
        user.setUpdateDate(ZonedDateTime.now());
        Basket basket = new Basket();
        basket.setUser(user);
        String token = jwtService.generateToken(user);
        userRepository.save(user);
        return AuthenticationResponse.builder()
                .token(token)
                .role(user.getRole().name())
                .email(user.getEmail())
                .build();
    }


    @Override
    public AuthenticationResponse signIn(SignIn signIn) {
        User user = userRepository.getUserByEmail(signIn.email()).orElseThrow(() -> new NotFoundException("user is not found"));
        if (signIn.email().isBlank()){
            throw new BadCredentialException("email does not exist...");
        }
        if (!passwordEncoder.matches(signIn.password(), user.getPassword())){
            throw new BadCredentialException("Incorrect password");
        }
        String token = jwtService.generateToken(user);

        return AuthenticationResponse.builder()
                .token(token)
                .role(user.getRole().name())
                .email(user.getEmail())
                .build();
    }
    @PostConstruct
    public  void init(){
        User user = new User();
        user.setFirstName("Davran");
        user.setLastName("Joldoshbaev");
        user.setPassword(passwordEncoder.encode("davran00"));
        user.setEmail("d@gmail.com");
        user.setRole(Role.ADMIN);
        user.setCreatedAt(ZonedDateTime.now());
        user.setUpdateDate(ZonedDateTime.now());

        if (!userRepository.existsByEmail(user.getEmail())){
            userRepository.save(user);
        }
    }
}
