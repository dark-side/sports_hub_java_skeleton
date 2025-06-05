package org.softserveinc.java_be_genai_plgrnd.dtos.response;

import java.time.ZonedDateTime;
import java.util.*;

import org.softserveinc.java_be_genai_plgrnd.dtos.business.ArticleDTO;
import org.softserveinc.java_be_genai_plgrnd.dtos.business.CommentDTO;
import org.softserveinc.java_be_genai_plgrnd.dtos.business.ImageStorageDTO;
import org.softserveinc.java_be_genai_plgrnd.models.enums.ReactionType;

import com.fasterxml.jackson.annotation.JsonProperty;

public record ArticleResponse(
    UUID id,
    String title,
    @JsonProperty("short_description")
    String shortDescription,
    String description,
    @JsonProperty("image_url")
    String imageUrl,
    @JsonProperty("comments_count")
    int commentsCount,
    @JsonProperty("comments_content")
    List<String> commentsContent,
    @JsonProperty("article_likes")
    int articleLikes,
    @JsonProperty("article_dislikes")
    int articleDislikes,
    @JsonProperty("created_at")
    ZonedDateTime creationTimestamp,
    @JsonProperty("updated_at")
    ZonedDateTime lastUpdateTimestamp
) {
    public static ArticleResponse fromDTO(ArticleDTO entityDTO) {
        List<String> comments = Optional.ofNullable(entityDTO.comments())
                .orElseGet(Set::of) // бо це Set<CommentDTO>
                .stream()
                .sorted(Comparator.comparing(CommentDTO::creationTimestamp).reversed())
                .map(CommentDTO::content)
                .toList();

        return new ArticleResponse(
            entityDTO.id(),
            entityDTO.title(),
            entityDTO.shortDescription(),
            entityDTO.description(),
            buildImageUrl(entityDTO.imageStorageDTO()),
            comments.size(),
            comments,
            entityDTO.reactionsCount().getOrDefault(ReactionType.LIKE, 0),
            entityDTO.reactionsCount().getOrDefault(ReactionType.DISLIKE, 0),
            entityDTO.creationTimestamp(),
            entityDTO.lastUpdateTimestamp()
        );
    }

    private static String buildImageUrl(ImageStorageDTO imageStorageDTO) {
        if (imageStorageDTO == null || imageStorageDTO.id() == null) {
            return null;
        }
        return "http://127.0.0.1:3002/api/images/" + imageStorageDTO.id();
    }
}
