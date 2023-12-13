package com.employee.management.model;

import com.employee.management.util.ValidationConstants;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class UserRequest {
    private String name;
    private String surname;
    @Email(message = "Make sure the email you enter has an sign: @")
    private String email;
    private boolean status;
    private String username;
    @Size(min = ValidationConstants.PASSWORD_MIN_LENGTH,
            max = ValidationConstants.PASSWORD_MAX_LENGTH,
            message = "Password must be at least 8 characters long"
    )
    @Pattern(regexp = ValidationConstants.PASSWORD_REGEX,
            message = "Password must contain at least one digit, one lowercase, one uppercase, and one special character")
    private String password;

    private Set<RoleDto> role;
}
