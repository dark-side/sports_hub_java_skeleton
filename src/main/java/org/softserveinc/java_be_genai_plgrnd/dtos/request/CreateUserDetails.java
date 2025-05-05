package org.softserveinc.java_be_genai_plgrnd.dtos.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record CreateUserDetails(
    @NotBlank
    @Email
    String email,
    @NotBlank
    @Pattern(
        regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$",
        message = """
            Password must be at least 8 characters long and contain at least one uppercase letter, \
            one lowercase letter, one number, and one special character\
            """
    )
    String password
) { }
