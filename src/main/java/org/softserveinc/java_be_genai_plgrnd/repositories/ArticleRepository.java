package org.softserveinc.java_be_genai_plgrnd.repositories;

import java.util.UUID;
import java.util.stream.Stream;

import org.softserveinc.java_be_genai_plgrnd.models.ArticleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
public interface ArticleRepository extends JpaRepository<ArticleEntity, UUID> {
    @Query("""
        SELECT a
        FROM ArticleEntity a JOIN FETCH a.comments
        """)
    Stream<ArticleEntity> findAllWithComments();
}
