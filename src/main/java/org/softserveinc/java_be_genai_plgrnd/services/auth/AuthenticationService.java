package org.softserveinc.java_be_genai_plgrnd.services.auth;

import org.softserveinc.java_be_genai_plgrnd.dtos.business.AuthenticationTokenDTO;
import org.softserveinc.java_be_genai_plgrnd.dtos.request.AuthenticationRequest;

public interface AuthenticationService {
    AuthenticationTokenDTO authenticate(AuthenticationRequest request);
}
