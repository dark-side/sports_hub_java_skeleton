package org.softserveinc.java_be_genai_plgrnd.dtos.business;

import org.softserveinc.java_be_genai_plgrnd.dtos.request.CreateUserRequest;

public record CreateUserDTO(
    String username,
    String email,
    String password
) {
    public static CreateUserDTO fromRequest(CreateUserRequest request) {
        return new CreateUserDTO(
            request.username(),
            request.email(),
            request.password()
        );
    }
}
