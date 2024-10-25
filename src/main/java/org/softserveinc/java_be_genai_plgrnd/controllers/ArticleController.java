package org.softserveinc.java_be_genai_plgrnd.controllers;

import java.util.List;

import org.softserveinc.java_be_genai_plgrnd.dtos.business.ArticleDTO;
import org.softserveinc.java_be_genai_plgrnd.services.ArticleService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@Tag(name = "Article", description = "Articles API")
@RestController
@RequestMapping(path = "/articles/v1", produces = APPLICATION_JSON_VALUE)
@Validated
public class ArticleController {
    private final ArticleService articleService;

    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @Operation(summary = "Find all articles with comments")
    @GetMapping(value = "/")
    public List<ArticleDTO> findAllWithComments() {
        return articleService.findAllWithComments();
    }
}
