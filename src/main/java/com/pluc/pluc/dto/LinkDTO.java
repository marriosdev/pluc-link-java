package com.pluc.pluc.dto;

import java.io.Serializable;
import java.time.Instant;

import com.pluc.pluc.entities.Link;

import lombok.Getter;

public class LinkDTO implements Serializable {
    
    @Getter Long id;
    @Getter String shortenedLink;
    @Getter String originalLink;
    @Getter Instant updatedAt;
    @Getter Instant createdAt;

    public LinkDTO(Long id, String shortened_link, String original_link, Instant updated_at, Instant created_at) {
        this.id = id;
        this.shortenedLink = shortened_link;
        this.originalLink = original_link;
        this.updatedAt = updated_at;
        this.createdAt = created_at;
    }
    
    public LinkDTO(Link entity) {
        this.id = entity.getId();
        this.shortenedLink = entity.getShortenedLink();
        this.originalLink = entity.getOriginalLink();
        this.updatedAt = entity.getUpdatedAt();
        this.createdAt = entity.getCreatedAt();
    }
}
