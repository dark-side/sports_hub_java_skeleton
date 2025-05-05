package org.softserveinc.java_be_genai_plgrnd.dtos.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record AuthenticationDetails(
    @NotBlank
    @Email
    String email,
    @NotBlank
    String password
) { }
