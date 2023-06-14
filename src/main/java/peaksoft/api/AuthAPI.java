package peaksoft.api;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.annotation.security.PermitAll;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import peaksoft.dto.Authentication.AdminTokenRequest;
import peaksoft.dto.Authentication.AuthenticationRequest;
import peaksoft.dto.Authentication.AuthenticationResponse;
import peaksoft.dto.Authentication.SignIn;
import peaksoft.service.AuthenticationService;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthAPI {
    private final AuthenticationService service;

    @PostMapping
    @Operation(description = "token", summary = "дает токен")
    public AuthenticationResponse getAdminToken(AdminTokenRequest adminTokenResponse){
        return service.adminToken(adminTokenResponse);
    }

    @PostMapping("/singUp")
    @PermitAll
    @Operation(description = "token", summary = "Регистрация")
    public AuthenticationResponse signUp(@RequestBody AuthenticationRequest authenticationRequest){
        return service.signUp(authenticationRequest);
    }
    @PostMapping("/signIn")
    @PermitAll
    @Operation(description = "token", summary = "Вход")
    public AuthenticationResponse signIn(@RequestBody SignIn signIn){
        return service.signIn(signIn);
    }
}
