package org.softserveinc.java_be_genai_plgrnd.dtos.business;

import java.util.UUID;

import org.softserveinc.java_be_genai_plgrnd.models.UserEntity;

public record UserDTO(
    UUID id,
    String email
) {
    public static UserDTO fromEntity(UserEntity entity) {
        return new UserDTO(
            entity.getId(),
            entity.getEmail()
        );
    }
}
