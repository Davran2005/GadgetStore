package peaksoft.api;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import peaksoft.dto.AuthenticationResponse;
import peaksoft.dto.SignInRequest;
import peaksoft.dto.SignUpRequest;
import peaksoft.dto.simpl.SimpleResponse;
import peaksoft.dto.user.UserRequest;
import peaksoft.dto.user.UserResponse;
import peaksoft.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserApi {
    private final UserService userService;

    @PostMapping("/signUp")
    AuthenticationResponse signUp(@RequestBody SignUpRequest signUpRequest) {
        return userService.signUp(signUpRequest);
    }

    @PostMapping("/signIn")
    AuthenticationResponse signIn(@RequestBody SignInRequest signInRequest) {
        return userService.signIn(signInRequest);
    }

    @GetMapping
    List<UserResponse> getAllUser() {
        return userService.getAllUser();
    }

    @GetMapping("/get")
    UserResponse getUser() {
        return userService.getUser();
    }

    @GetMapping("/{id}")
    UserResponse getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @PutMapping("/{id}")
    SimpleResponse updateUserById(@PathVariable Long id, @RequestBody UserRequest userRequest) {
        return userService.updateUserById(id, userRequest);
    }

    @DeleteMapping("/{id}")
    SimpleResponse deleteById(@PathVariable Long id) {
        return userService.deleteById(id);
    }
}