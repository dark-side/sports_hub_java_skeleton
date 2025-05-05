package org.softserveinc.java_be_genai_plgrnd.dtos.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;

public record AuthenticationRequest(
    @NotNull
    @JsonProperty("user")
    AuthenticationDetails authenticationDetails
) { }
