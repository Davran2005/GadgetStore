package peaksoft.dto.Authentication;

import lombok.Builder;

@Builder
public record SignIn(
        String email,
        String password) {
}
