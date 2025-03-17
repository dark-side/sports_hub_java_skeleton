package org.softserveinc.java_be_genai_plgrnd.repositories;

import java.util.Set;
import java.util.UUID;

import org.softserveinc.java_be_genai_plgrnd.models.ReactionEntity;
import org.softserveinc.java_be_genai_plgrnd.models.enums.ContentType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReactionRepository extends JpaRepository<ReactionEntity, Long> {

    Set<ReactionEntity> findAllByContentTypeAndContentId(ContentType contentType, UUID contentId);
    Set<ReactionEntity> findAllByContentType(ContentType contentType);
}
