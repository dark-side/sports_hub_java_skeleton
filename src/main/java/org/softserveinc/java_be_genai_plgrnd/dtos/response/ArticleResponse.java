package org.softserveinc.java_be_genai_plgrnd.dtos.response;

import java.time.ZonedDateTime;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

import org.softserveinc.java_be_genai_plgrnd.dtos.business.ArticleDTO;

public record ArticleResponse(
    UUID id,
    String title,
    String shortDescription,
    String description,
    Set<CommentResponse> comments,
    ZonedDateTime creationTimestamp,
    ZonedDateTime lastUpdateTimestamp
) {
    public static ArticleResponse fromEntity(ArticleDTO entity) {
        final var comments = entity.comments() == null
            ? Set.<CommentResponse>of()
            : entity.comments().stream().map(CommentResponse::fromDTO).collect(Collectors.toSet());

        return new ArticleResponse(
            entity.id(),
            entity.title(),
            entity.shortDescription(),
            entity.description(),
            comments,
            entity.creationTimestamp(),
            entity.lastUpdateTimestamp()
        );
    }
}
