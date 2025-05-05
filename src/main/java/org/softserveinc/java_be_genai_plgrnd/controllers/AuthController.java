package org.softserveinc.java_be_genai_plgrnd.controllers;

import org.softserveinc.java_be_genai_plgrnd.dtos.business.CreateUserDTO;
import org.softserveinc.java_be_genai_plgrnd.dtos.request.AuthenticationRequest;
import org.softserveinc.java_be_genai_plgrnd.dtos.request.CreateUserRequest;
import org.softserveinc.java_be_genai_plgrnd.dtos.response.AuthenticationTokenResponse;
import org.softserveinc.java_be_genai_plgrnd.dtos.response.UserResponse;
import org.softserveinc.java_be_genai_plgrnd.services.UserService;
import org.softserveinc.java_be_genai_plgrnd.services.auth.AuthenticationService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@Tag(name = "Auth", description = "Auth API")
@RestController
@RequestMapping(produces = APPLICATION_JSON_VALUE)
@Validated
public class AuthController {

    private final UserService userService;
    private final AuthenticationService authenticationService;

    public AuthController(
        UserService userService,
        AuthenticationService authenticationService
    ) {
        this.userService = userService;
        this.authenticationService = authenticationService;
    }

    @PostMapping("/users")
    public ResponseEntity<UserResponse> registerUser(
        @Valid @RequestBody CreateUserRequest registrationDTO
    ) {
        final var registeredUser = userService.registerUser(CreateUserDTO.fromRequest(registrationDTO));

        return ResponseEntity.ok(
           UserResponse.fromDTO(registeredUser)
        );
    }

    @PostMapping("/api/auth/sign_in")
    public ResponseEntity<AuthenticationTokenResponse> authenticate(
        @Valid @RequestBody AuthenticationRequest authenticationRequest
    ) {
        return ResponseEntity.ok(
            AuthenticationTokenResponse.fromDTO(authenticationService.authenticate(authenticationRequest))
        );
    }

}
