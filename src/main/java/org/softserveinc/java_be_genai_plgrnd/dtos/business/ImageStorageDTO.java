package org.softserveinc.java_be_genai_plgrnd.dtos.business;

import java.time.ZonedDateTime;
import java.util.UUID;

import org.softserveinc.java_be_genai_plgrnd.models.ImageStorageEntity;

public record ImageStorageDTO(
    UUID id,
    String image,
    ZonedDateTime creationTimestamp,
    ZonedDateTime lastUpdateTimestamp
) {
    public static ImageStorageDTO fromEntity(ImageStorageEntity entity) {
        return new ImageStorageDTO(
            entity.getId(),
            entity.getImage(),
            entity.getCreationTimestamp(),
            entity.getLastUpdateTimestamp()
        );
    }
}
