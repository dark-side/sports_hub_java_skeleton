package org.softserveinc.java_be_genai_plgrnd.services.auth;

import org.softserveinc.java_be_genai_plgrnd.dtos.business.AuthenticationTokenDTO;
import org.softserveinc.java_be_genai_plgrnd.dtos.request.AuthenticationRequest;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    public AuthenticationServiceImpl(
        AuthenticationManager authenticationManager,
        JwtService jwtService
    ) {
        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
    }

    @Override
    public AuthenticationTokenDTO authenticate(final AuthenticationRequest request) {

        final var authToken = UsernamePasswordAuthenticationToken
            .unauthenticated(request.authenticationDetails().email(), request.authenticationDetails().password());

        authenticationManager.authenticate(authToken);

        final var token = jwtService.generateToken(request.authenticationDetails().email());
        return new AuthenticationTokenDTO(
            null,
            request.authenticationDetails().email(),
            token
        );
    }
}
