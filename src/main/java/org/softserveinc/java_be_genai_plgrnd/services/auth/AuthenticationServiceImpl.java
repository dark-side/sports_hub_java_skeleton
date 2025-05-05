package org.softserveinc.java_be_genai_plgrnd.services.auth;

import org.softserveinc.java_be_genai_plgrnd.dtos.business.AuthenticationTokenDTO;
import org.softserveinc.java_be_genai_plgrnd.dtos.request.AuthenticationRequest;
import org.softserveinc.java_be_genai_plgrnd.models.UserEntity;
import org.softserveinc.java_be_genai_plgrnd.repositories.UserRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    private final UserRepository userRepository;

    public AuthenticationServiceImpl(
        AuthenticationManager authenticationManager,
        JwtService jwtService,
        UserRepository userRepository
    ) {
        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
        this.userRepository = userRepository;
    }

    @Override
    public AuthenticationTokenDTO authenticate(final AuthenticationRequest request) {

        final var email = request.authenticationDetails().email();
        final var password = request.authenticationDetails().password();
        final var authToken = UsernamePasswordAuthenticationToken.unauthenticated(email, password);

        authenticationManager.authenticate(authToken);

        final var id = userRepository
            .findByEmail(email)
            .map(UserEntity::getId)
            .orElse(null);

        final var token = jwtService.generateToken(email);
        return new AuthenticationTokenDTO(id, email, token);
    }
}
