package org.softserveinc.java_be_genai_plgrnd.dtos.business;

import java.time.ZonedDateTime;
import java.util.Objects;
import java.util.UUID;

import org.softserveinc.java_be_genai_plgrnd.models.CommentEntity;

public record CommentDTO(
    UUID id,
    String content,
    ZonedDateTime creationTimestamp,
    ZonedDateTime lastUpdateTimestamp
) {
    public static CommentDTO fromEntity(CommentEntity entity) {
        return new CommentDTO(
            entity.getId(),
            entity.getContent(),
            entity.getCreationTimestamp(),
            entity.getLastUpdateTimestamp()
        );
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof CommentDTO that)) {
            return false;
        }

        return Objects.equals(id, that.id)
            && Objects.equals(content, that.content)
            && Objects.equals(creationTimestamp, that.creationTimestamp)
            && Objects.equals(lastUpdateTimestamp, that.lastUpdateTimestamp);
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(id);
        result = 31 * result + Objects.hashCode(content);
        result = 31 * result + Objects.hashCode(creationTimestamp);
        result = 31 * result + Objects.hashCode(lastUpdateTimestamp);
        return result;
    }
}
