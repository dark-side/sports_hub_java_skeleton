package org.softserveinc.java_be_genai_plgrnd.dtos.response;

import org.softserveinc.java_be_genai_plgrnd.dtos.business.UserDTO;

public record UserResponse(
    String username,
    String email
) {
    public static UserResponse fromDTO(UserDTO dto) {
        return new UserResponse(
            dto.username(),
            dto.email()
        );
    }
}
