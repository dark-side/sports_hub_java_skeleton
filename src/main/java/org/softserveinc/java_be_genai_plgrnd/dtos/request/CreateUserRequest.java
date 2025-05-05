package org.softserveinc.java_be_genai_plgrnd.dtos.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;

public record CreateUserRequest(
    @NotNull
    @JsonProperty("registration")
    CreateUserDetails userDetails
) { }
