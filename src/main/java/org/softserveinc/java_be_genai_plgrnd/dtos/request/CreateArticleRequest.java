package org.softserveinc.java_be_genai_plgrnd.dtos.request;

import jakarta.validation.constraints.NotBlank;

public record CreateArticleRequest(
    @NotBlank
    String title,
    @NotBlank
    String shortDescription,
    @NotBlank
    String description,
    @NotBlank
    String image
) { }
