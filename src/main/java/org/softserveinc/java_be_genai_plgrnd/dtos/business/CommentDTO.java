package org.softserveinc.java_be_genai_plgrnd.dtos.business;

import java.time.ZonedDateTime;
import java.util.UUID;

import org.softserveinc.java_be_genai_plgrnd.models.CommentEntity;

public record CommentDTO(
    UUID id,
    String content,
    ZonedDateTime creationTimestamp,
    ZonedDateTime lastUpdateTimestamp
) {
    public static CommentDTO fromEntity(CommentEntity entity) {
        return new CommentDTO(
            entity.getId(),
            entity.getContent(),
            entity.getCreationTimestamp(),
            entity.getLastUpdateTimestamp()
        );
    }
}
