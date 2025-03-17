package org.softserveinc.java_be_genai_plgrnd.services;

import java.util.Optional;
import java.util.UUID;

public interface ImageStorageService {
    Optional<String> getBase64ImageById(UUID imageId);
}
