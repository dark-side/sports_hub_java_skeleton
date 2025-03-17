package org.softserveinc.java_be_genai_plgrnd.models;

import java.time.ZonedDateTime;
import java.util.UUID;

import org.softserveinc.java_be_genai_plgrnd.models.enums.ContentType;
import org.softserveinc.java_be_genai_plgrnd.models.enums.ReactionType;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "reactions")
@EntityListeners(AuditingEntityListener.class)
public class ReactionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "content_type", nullable = false)
    @Enumerated(EnumType.STRING)
    private ContentType contentType;

    @Column(name = "content_id", nullable = false)
    private UUID contentId;

    @CreatedBy
    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id", nullable = false, updatable = false)
    private UserEntity user;

    @Column(name = "reaction_type", nullable = false)
    @Enumerated(EnumType.STRING)
    private ReactionType reactionType;

    @Column(name = "creation_timestamp", nullable = false, updatable = false)
    @CreatedDate
    private ZonedDateTime creationTimestamp;

    @Column(name = "last_update_timestamp", nullable = false)
    @LastModifiedDate
    private ZonedDateTime lastUpdateTimestamp;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ContentType getContentType() {
        return contentType;
    }

    public void setContentType(ContentType contentType) {
        this.contentType = contentType;
    }

    public UUID getContentId() {
        return contentId;
    }

    public void setContentId(UUID contentId) {
        this.contentId = contentId;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public ReactionType getReactionType() {
        return reactionType;
    }

    public void setReactionType(ReactionType reactionType) {
        this.reactionType = reactionType;
    }

    public ZonedDateTime getCreationTimestamp() {
        return creationTimestamp;
    }

    public void setCreationTimestamp(ZonedDateTime creationTimestamp) {
        this.creationTimestamp = creationTimestamp;
    }

    public ZonedDateTime getLastUpdateTimestamp() {
        return lastUpdateTimestamp;
    }

    public void setLastUpdateTimestamp(ZonedDateTime lastUpdateTimestamp) {
        this.lastUpdateTimestamp = lastUpdateTimestamp;
    }

    @Override
    public final boolean equals(Object o) {
        if (!(o instanceof ReactionEntity that))
            return false;

        return contentType == that.contentType
            && contentId.equals(that.contentId)
            && user.getId().equals(that.user.getId());
    }

    @Override
    public int hashCode() {
        int result = contentType.hashCode();
        result = 31 * result + contentId.hashCode();
        result = 31 * result + user.getId().hashCode();
        return result;
    }
}
