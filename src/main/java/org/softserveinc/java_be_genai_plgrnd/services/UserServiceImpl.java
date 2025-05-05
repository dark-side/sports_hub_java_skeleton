package org.softserveinc.java_be_genai_plgrnd.services;

import org.softserveinc.java_be_genai_plgrnd.dtos.business.CreateUserDTO;
import org.softserveinc.java_be_genai_plgrnd.dtos.business.UserDTO;
import org.softserveinc.java_be_genai_plgrnd.exception.ResourceConflictException;
import org.softserveinc.java_be_genai_plgrnd.models.UserEntity;
import org.softserveinc.java_be_genai_plgrnd.repositories.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional
    @Override
    public UserDTO registerUser(CreateUserDTO request) {
        if (userRepository.existsByEmail(request.email())) {
            throw new ResourceConflictException("Email already exists");
        }

        final var user = new UserEntity();
        user.setEmail(request.email());
        user.setPassword(passwordEncoder.encode(request.password()));

        return UserDTO.fromEntity(userRepository.save(user));
    }
}
