package org.softserveinc.java_be_genai_plgrnd.services;

import java.util.List;
import java.util.UUID;

import org.softserveinc.java_be_genai_plgrnd.dtos.business.ArticleDTO;
import org.softserveinc.java_be_genai_plgrnd.dtos.business.CreateArticleDTO;
import org.softserveinc.java_be_genai_plgrnd.exception.ResourceNotFoundException;
import org.softserveinc.java_be_genai_plgrnd.models.ArticleEntity;
import org.softserveinc.java_be_genai_plgrnd.repositories.ArticleRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ArticleServiceImpl implements ArticleService {
    private final ArticleRepository articleRepository;

    public ArticleServiceImpl(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    /**
     * Find all articles with comments.
     *
     * @return list of articles with comments sorted by creation timestamp in descending order
     */
    @Override
    @Transactional(readOnly = true)
    public List<ArticleDTO> findAllWithComments() {
        return articleRepository.findAllWithComments()
            .stream()
            .map(ArticleDTO::fromEntity)
            .sorted((a1, a2) -> a2.creationTimestamp().compareTo(a1.creationTimestamp()))
            .toList();
    }

    /**
     * Find article by id.
     *
     * @param id article id
     * @return article
     * @throws ResourceNotFoundException if article not found
     */
    @Override
    public ArticleDTO findById(String id) {
        return articleRepository.findById(UUID.fromString(id))
            .map(ArticleDTO::fromEntity)
            .orElseThrow(() -> new ResourceNotFoundException("Article", id));
    }

    /**
     * Create article.
     *
     * @param createArticleDTO article data
     * @return created article
     */
    @Override
    @Transactional
    public ArticleDTO createArticle(CreateArticleDTO createArticleDTO) {
        final var article = new ArticleEntity();
        article.setTitle(createArticleDTO.title());
        article.setShortDescription(createArticleDTO.shortDescription());
        article.setDescription(createArticleDTO.description());
        return ArticleDTO.fromEntity(articleRepository.save(article));
    }
}
