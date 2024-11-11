package org.softserveinc.java_be_genai_plgrnd.repositories;

import java.util.Optional;
import java.util.UUID;

import org.softserveinc.java_be_genai_plgrnd.models.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
public interface UserRepository extends JpaRepository<UserEntity, UUID> {
    boolean existsByUsername(String username);
    boolean existsByEmail(String email);
    Optional<UserEntity> findByEmail(String email);
}
