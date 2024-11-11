package org.softserveinc.java_be_genai_plgrnd.services.auth;

public interface JwtService {
    String generateToken(String email);
}
