package org.softserveinc.java_be_genai_plgrnd.services;

import java.util.List;

import org.softserveinc.java_be_genai_plgrnd.dtos.business.ArticleDTO;
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
            .map(ArticleDTO::fromEntity)
            .sorted((a1, a2) -> a2.creationTimestamp().compareTo(a1.creationTimestamp()))
            .toList();
    }
}
