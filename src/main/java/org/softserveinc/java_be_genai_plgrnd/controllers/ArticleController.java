package org.softserveinc.java_be_genai_plgrnd.controllers;

import java.util.List;

import org.softserveinc.java_be_genai_plgrnd.dtos.business.CreateArticleDTO;
import org.softserveinc.java_be_genai_plgrnd.dtos.request.CreateArticleRequest;
import org.softserveinc.java_be_genai_plgrnd.dtos.response.ArticleResponse;
import org.softserveinc.java_be_genai_plgrnd.services.ArticleService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@Tag(name = "Article", description = "Articles API")
@RestController
@RequestMapping(path = "/articles", produces = APPLICATION_JSON_VALUE)
@Validated
public class ArticleController {
    private final ArticleService articleService;

    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @Operation(summary = "Find all articles with comments")
    @GetMapping(value = "/")
    public List<ArticleResponse> findAllWithComments() {
        return articleService.findAllWithComments()
            .stream()
            .map(ArticleResponse::fromEntity)
            .toList();
    }

    @Operation(summary = "Find an article with comments by id")
    @GetMapping(value = "/{id}")
    public ArticleResponse findArticleById(
        @PathVariable String id
    ) {
        return ArticleResponse.fromEntity(articleService.findById(id));
    }

    @Operation(summary = "Create an article")
    @PostMapping(value = "/")
    public ArticleResponse createArticle(
        @RequestBody @Valid CreateArticleRequest request
    ) {
        return ArticleResponse.fromEntity(
            articleService.createArticle(
                CreateArticleDTO.fromRequest(request)
            )
        );
    }
}
