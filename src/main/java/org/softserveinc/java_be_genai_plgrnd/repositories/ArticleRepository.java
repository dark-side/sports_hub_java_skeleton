package org.softserveinc.java_be_genai_plgrnd.repositories;

import java.util.Set;
import java.util.UUID;

import org.softserveinc.java_be_genai_plgrnd.models.ArticleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
public interface ArticleRepository extends JpaRepository<ArticleEntity, UUID> {
    @Query("""
        SELECT a
        FROM ArticleEntity a LEFT JOIN FETCH a.comments
        """)
    Set<ArticleEntity> findAllWithComments();
}
