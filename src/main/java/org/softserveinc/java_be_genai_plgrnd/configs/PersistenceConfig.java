package org.softserveinc.java_be_genai_plgrnd.configs;

import java.time.ZonedDateTime;
import java.util.Optional;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.auditing.DateTimeProvider;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaAuditing(dateTimeProviderRef = "auditingZonedDateTimeProvider")
public class PersistenceConfig {

    @Bean
    public DateTimeProvider auditingZonedDateTimeProvider() {
        return () -> Optional.of(ZonedDateTime.now());
    }
}
