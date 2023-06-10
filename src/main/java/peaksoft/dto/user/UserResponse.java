package peaksoft.dto.user;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;
import peaksoft.enums.Role;

import java.time.ZonedDateTime;
@Getter
@Setter
@NoArgsConstructor
@Builder
public class UserResponse {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private ZonedDateTime createdDate;
    private ZonedDateTime updateDate;
    private Role role;

    public UserResponse(Long id, String firstName, String lastName, String email, String password, ZonedDateTime createdDate, ZonedDateTime updateDate, Role role) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.createdDate = createdDate;
        this.updateDate = updateDate;
        this.role = role;
    }
}
