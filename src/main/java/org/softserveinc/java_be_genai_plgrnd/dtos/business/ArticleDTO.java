package org.softserveinc.java_be_genai_plgrnd.dtos.business;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

import org.softserveinc.java_be_genai_plgrnd.models.ArticleEntity;
import org.softserveinc.java_be_genai_plgrnd.models.ReactionEntity;
import org.softserveinc.java_be_genai_plgrnd.models.enums.ReactionType;

public record ArticleDTO(
    UUID id,
    String title,
    String shortDescription,
    String description,
    ImageStorageDTO imageStorageDTO,
    Set<CommentDTO> comments,
    Map<ReactionType, Integer> reactionsCount,
    ZonedDateTime creationTimestamp,
    ZonedDateTime lastUpdateTimestamp
) {
    public static ArticleDTO fromEntity(ArticleEntity entity, List<ReactionEntity> reactions) {
        final var comments = entity.getComments() == null
            ? Set.<CommentDTO>of()
            : entity.getComments().stream().map(CommentDTO::fromEntity).collect(Collectors.toSet());

        return new ArticleDTO(
            entity.getId(),
            entity.getTitle(),
            entity.getShortDescription(),
            entity.getDescription(),
            ImageStorageDTO.fromEntity(entity.getImageStorage()),
            comments,
            getReactionsCount(reactions),
            entity.getCreationTimestamp(),
            entity.getLastUpdateTimestamp()
        );
    }

    private static Map<ReactionType, Integer> getReactionsCount(List<ReactionEntity> reactions) {
        if (reactions == null || reactions.isEmpty()) {
            return Map.of();
        }
        return reactions.stream()
            .collect(Collectors.groupingBy(ReactionEntity::getReactionType, Collectors.summingInt(r -> 1)));

    }
}
