package peaksoft.service;

import peaksoft.dto.AuthenticationResponse;
import peaksoft.dto.SignInRequest;
import peaksoft.dto.SignUpRequest;
import peaksoft.dto.simpl.SimpleResponse;
import peaksoft.dto.user.UserRequest;
import peaksoft.dto.user.UserResponse;

import java.util.List;
import java.util.Optional;

public interface UserService {
    AuthenticationResponse signUp(SignUpRequest signUpRequest);

    AuthenticationResponse signIn(SignInRequest signInRequest);
    List<UserResponse> getAllUser();
    UserResponse getUser();
    UserResponse getUserById(Long id);
    SimpleResponse updateUserById(Long id,UserRequest userRequest);
    SimpleResponse deleteById(Long id);
}
