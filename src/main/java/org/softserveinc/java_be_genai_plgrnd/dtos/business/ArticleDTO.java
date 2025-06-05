package org.softserveinc.java_be_genai_plgrnd.dtos.business;

import java.time.ZonedDateTime;
import java.util.*;
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
        Set<CommentDTO> comments = entity.getComments() == null
                ? Set.of()
                : entity.getComments().stream()
                .map(CommentDTO::fromEntity)
                .collect(Collectors.toCollection(LinkedHashSet::new));

        Map<ReactionType, Integer> reactionsCount = getReactionsCount(reactions);

        ImageStorageDTO image = entity.getImageStorage() != null
                ? ImageStorageDTO.fromEntity(entity.getImageStorage())
                : null;

        return new ArticleDTO(
                entity.getId(),
                entity.getTitle(),
                entity.getShortDescription(),
                entity.getDescription(),
                image,
                comments,
                reactionsCount,
                entity.getCreationTimestamp(),
                entity.getLastUpdateTimestamp()
        );
    }

    private static Map<ReactionType, Integer> getReactionsCount(List<ReactionEntity> reactions) {
        if (reactions == null || reactions.isEmpty()) {
            return Map.of();
        }

        Map<ReactionType, Integer> map = new EnumMap<>(ReactionType.class);
        for (ReactionEntity reaction : reactions) {
            map.merge(reaction.getReactionType(), 1, Integer::sum);
        }
        return map;
    }

}
