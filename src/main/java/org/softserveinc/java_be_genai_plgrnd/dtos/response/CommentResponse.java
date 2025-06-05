package org.softserveinc.java_be_genai_plgrnd.dtos.response;

import java.time.ZonedDateTime;
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
}
