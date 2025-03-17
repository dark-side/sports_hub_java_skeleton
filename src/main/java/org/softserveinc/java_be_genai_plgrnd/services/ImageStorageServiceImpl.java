package org.softserveinc.java_be_genai_plgrnd.services;

import java.util.Optional;
import java.util.UUID;

import org.softserveinc.java_be_genai_plgrnd.models.ImageStorageEntity;
import org.softserveinc.java_be_genai_plgrnd.repositories.ImageStorageRepository;
import org.springframework.stereotype.Service;

@Service
public class ImageStorageServiceImpl implements ImageStorageService {
    private final ImageStorageRepository imageStorageRepository;

    public ImageStorageServiceImpl(ImageStorageRepository imageStorageRepository) {
        this.imageStorageRepository = imageStorageRepository;
    }

    @Override
    public Optional<String> getBase64ImageById(UUID imageId) {
        return imageStorageRepository.findById(imageId)
            .map(ImageStorageEntity::getImage);
    }
}
