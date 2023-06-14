package peaksoft.dto.Authentication;

import lombok.Builder;

@Builder
public record AdminTokenRequest(String email) {
    public AdminTokenRequest {
    }
}
