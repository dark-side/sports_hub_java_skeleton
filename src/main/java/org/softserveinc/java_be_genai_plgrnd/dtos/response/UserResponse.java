package org.softserveinc.java_be_genai_plgrnd.dtos.response;

import java.util.UUID;

import org.softserveinc.java_be_genai_plgrnd.dtos.business.UserDTO;

public record UserResponse(
    UUID id,
    String email
) {
    public static UserResponse fromDTO(UserDTO dto) {
        return new UserResponse(
            dto.id(),
            dto.email()
        );
    }
}
