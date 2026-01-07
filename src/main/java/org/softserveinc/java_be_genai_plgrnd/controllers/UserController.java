package org.softserveinc.java_be_genai_plgrnd.controllers;

import org.softserveinc.java_be_genai_plgrnd.dtos.business.CreateUserDTO;
import org.softserveinc.java_be_genai_plgrnd.dtos.request.CreateUserRequest;
import org.softserveinc.java_be_genai_plgrnd.dtos.response.UserResponse;
import org.softserveinc.java_be_genai_plgrnd.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@Tag(name = "User", description = "Users API")
@RestController
@RequestMapping(path = "/api/users", produces = APPLICATION_JSON_VALUE)
@Validated
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @Operation(summary = "Register a new user")
    @PostMapping
    public ResponseEntity<UserResponse> registerUser(
        @RequestBody @Valid CreateUserRequest request
    ) {
        return ResponseEntity.ok(
            UserResponse.fromDTO(
                userService.registerUser(
                    CreateUserDTO.fromRequest(request)
                )
            )
        );
    }
}
