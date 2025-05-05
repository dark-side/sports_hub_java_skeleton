package org.softserveinc.java_be_genai_plgrnd.dtos.response;

import java.util.UUID;

import org.softserveinc.java_be_genai_plgrnd.dtos.business.AuthenticationTokenDTO;

public record AuthenticationTokenResponse(
    UUID id,
    String email,
    String token
) {
    public static AuthenticationTokenResponse fromDTO(AuthenticationTokenDTO token) {
        return new AuthenticationTokenResponse(token.id(), token.email(), token.token());
    }
}
