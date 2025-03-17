package org.softserveinc.java_be_genai_plgrnd.dtos.business;

import org.softserveinc.java_be_genai_plgrnd.dtos.request.CreateArticleRequest;

public record CreateArticleDTO(
    String title,
    String shortDescription,
    String description,
    String image
) {
    public static CreateArticleDTO fromRequest(CreateArticleRequest request) {
        return new CreateArticleDTO(
            request.title(),
            request.shortDescription(),
            request.description(),
            request.image()
        );
    }
}
