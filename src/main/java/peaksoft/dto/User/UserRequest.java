package peaksoft.dto.User;

import lombok.Builder;

@Builder
public record UserRequest(String firsName,
                          String lastName,
                          String email,
                          String password) {
    public UserRequest {
    }
}
