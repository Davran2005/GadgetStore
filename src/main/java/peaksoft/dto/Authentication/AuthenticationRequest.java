package peaksoft.dto.Authentication;

import lombok.Builder;

@Builder
public record AuthenticationRequest(
        String firstName,
        String lastName,
        String email,
        String password
) {
}
