package org.softserveinc.java_be_genai_plgrnd;

import java.util.concurrent.atomic.AtomicInteger;

import org.softserveinc.java_be_genai_plgrnd.dtos.business.CreateUserDTO;
import org.softserveinc.java_be_genai_plgrnd.dtos.request.AuthenticationDetails;
import org.softserveinc.java_be_genai_plgrnd.dtos.request.AuthenticationRequest;
import org.softserveinc.java_be_genai_plgrnd.services.UserService;
import org.softserveinc.java_be_genai_plgrnd.services.auth.AuthenticationService;

public class AuthenticationHelper {
    public static final AtomicInteger UNIQUE_ID = new AtomicInteger(0);

    private final UserService userService;
    private final AuthenticationService authenticationService;

    public AuthenticationHelper(
        UserService userService,
        AuthenticationService authenticationService
    ) {
        this.userService = userService;
        this.authenticationService = authenticationService;
    }

    public String createUserAndGenerateToken() {
        final int id = UNIQUE_ID.incrementAndGet();
        final var newUser = new CreateUserDTO(
            "testEmail" + id + "@test.com",
            "testPassword" + id
        );
        userService.registerUser(newUser);
        return authenticationService.authenticate(
            new AuthenticationRequest(
                new AuthenticationDetails(
                    newUser.email(), newUser.password()
                )
            )
        ).token();
    }
}
