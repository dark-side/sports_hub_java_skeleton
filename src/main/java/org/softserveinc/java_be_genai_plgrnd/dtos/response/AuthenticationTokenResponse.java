package org.softserveinc.java_be_genai_plgrnd.dtos.response;

import org.softserveinc.java_be_genai_plgrnd.dtos.business.AuthenticationTokenDTO;

public record AuthenticationTokenResponse(
    String token
) {
    public static AuthenticationTokenResponse fromDTO(AuthenticationTokenDTO token) {
        return new AuthenticationTokenResponse(token.token());
    }
}
