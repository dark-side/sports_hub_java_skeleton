package org.softserveinc.java_be_genai_plgrnd.repositories;

import java.util.UUID;

import org.softserveinc.java_be_genai_plgrnd.models.ImageStorageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
public interface ImageStorageRepository extends JpaRepository<ImageStorageEntity, UUID> {
}
