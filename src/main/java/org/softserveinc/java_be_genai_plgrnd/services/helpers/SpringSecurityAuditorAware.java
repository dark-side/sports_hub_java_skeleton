package org.softserveinc.java_be_genai_plgrnd.services.helpers;

import java.util.Optional;

import org.softserveinc.java_be_genai_plgrnd.configs.PersistenceConfig;
import org.softserveinc.java_be_genai_plgrnd.models.UserEntity;
import org.softserveinc.java_be_genai_plgrnd.repositories.UserRepository;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.stereotype.Component;

@Component(PersistenceConfig.AUDITOR_AWARE)
public class SpringSecurityAuditorAware implements AuditorAware<UserEntity> {
    private final UserRepository userRepository;

    public SpringSecurityAuditorAware(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Optional<UserEntity> getCurrentAuditor() {
        return Optional.ofNullable(SecurityContextHolder.getContext())
            .map(SecurityContext::getAuthentication)
            .filter(JwtAuthenticationToken.class::isInstance)
            .map(JwtAuthenticationToken.class::cast)
            .filter(JwtAuthenticationToken::isAuthenticated)
            .map(JwtAuthenticationToken::getName)
            .flatMap(userRepository::findByEmail);
    }
}
