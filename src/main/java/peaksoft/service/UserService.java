package peaksoft.service;

import peaksoft.dto.simpl.SimpleResponse;
import peaksoft.dto.user.UserRequest;
import peaksoft.dto.user.UserResponse;

import java.util.List;

public interface UserService {
    SimpleResponse saveUser(UserRequest userRequest);
    List<UserResponse> getAllUser();
    UserResponse getUserById(Long id);
    SimpleResponse updateUserById(Long id,UserRequest userRequest);
    SimpleResponse deleteById(Long id);
}
