package org.softserveinc.java_be_genai_plgrnd.services;

import org.softserveinc.java_be_genai_plgrnd.dtos.business.CreateUserDTO;
import org.softserveinc.java_be_genai_plgrnd.dtos.business.UserDTO;

public interface UserService {
    UserDTO registerUser(CreateUserDTO request);
}
