package peaksoft.service;

import peaksoft.dto.Authentication.AdminTokenRequest;
import peaksoft.dto.Authentication.AuthenticationRequest;
import peaksoft.dto.Authentication.AuthenticationResponse;
import peaksoft.dto.Authentication.SignIn;


public interface AuthenticationService {
    AuthenticationResponse adminToken(AdminTokenRequest adminTokenResponse);
    AuthenticationResponse signUp(AuthenticationRequest authenticationRequest);
    AuthenticationResponse signIn(SignIn signIn);
}
