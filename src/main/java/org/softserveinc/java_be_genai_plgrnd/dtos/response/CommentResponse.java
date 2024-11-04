package org.softserveinc.java_be_genai_plgrnd.dtos.response;

import java.time.ZonedDateTime;
import java.util.Objects;
import java.util.UUID;

import org.softserveinc.java_be_genai_plgrnd.dtos.business.CommentDTO;

public record CommentResponse(
    UUID id,
    String content,
    ZonedDateTime creationTimestamp,
    ZonedDateTime lastUpdateTimestamp
) {
    public static CommentResponse fromDTO(CommentDTO dto) {
        return new CommentResponse(
            dto.id(),
            dto.content(),
            dto.creationTimestamp(),
            dto.lastUpdateTimestamp()
        );
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof CommentResponse that)) {
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
