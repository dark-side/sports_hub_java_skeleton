package org.softserveinc.java_be_genai_plgrnd.services.auth;

import java.time.Duration;
import java.time.Instant;
import java.time.temporal.ChronoUnit;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.stereotype.Service;

@Service
public class JwtServiceImpl implements JwtService {

    @Value("${spring.application.name}")
    private String issuer;
    private final JwtEncoder jwtEncoder;

    public JwtServiceImpl(JwtEncoder jwtEncoder) {
        this.jwtEncoder = jwtEncoder;
    }

    @Override
    public String generateToken(final String email) {
        final var claimsSet = JwtClaimsSet.builder()
            .subject(email)
            .issuer(issuer)
            .expiresAt(Instant.now().plus(Duration.of(365, ChronoUnit.DAYS)))
            .build();

        return jwtEncoder
            .encode(JwtEncoderParameters.from(claimsSet))
            .getTokenValue();
    }
}
