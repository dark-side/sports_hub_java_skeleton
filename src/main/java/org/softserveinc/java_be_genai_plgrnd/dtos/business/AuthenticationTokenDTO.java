package org.softserveinc.java_be_genai_plgrnd.dtos.business;

import java.util.UUID;

public record AuthenticationTokenDTO(
    UUID id,
    String email,
    String token
) { }
