package org.softserveinc.java_be_genai_plgrnd.dtos.business;

import java.time.ZonedDateTime;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

import org.softserveinc.java_be_genai_plgrnd.models.ArticleEntity;

public record ArticleDTO(
    UUID id,
    String title,
    String shortDescription,
    String description,
    Set<CommentDTO> comments,
    ZonedDateTime creationTimestamp,
    ZonedDateTime lastUpdateTimestamp
) {
    public static ArticleDTO fromEntity(ArticleEntity entity) {
        final var comments = entity.getComments() == null
            ? Set.<CommentDTO>of()
            : entity.getComments().stream().map(CommentDTO::fromEntity).collect(Collectors.toSet());

        return new ArticleDTO(
            entity.getId(),
            entity.getTitle(),
            entity.getShortDescription(),
            entity.getDescription(),
            comments,
            entity.getCreationTimestamp(),
            entity.getLastUpdateTimestamp()
        );
    }
}
