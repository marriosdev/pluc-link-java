package com.pluc.pluc.dto;

import java.io.Serializable;
import java.time.Instant;

import javax.crypto.interfaces.PBEKey;

import com.pluc.pluc.entities.Link;

public class LinkDTO implements Serializable {
    Long id;

    String shortened_link;
    String original_link;
    Instant updated_at;
    Instant created_at;
    Instant deleted_at;

    public LinkDTO(Long id, String shortened_link, String original_link, Instant updated_at, Instant created_at, Instant deleted_at) {
        this.id = id;
        this.shortened_link = shortened_link;
        this.original_link = original_link;
        this.updated_at = updated_at;
        this.created_at = created_at;
        this.deleted_at = deleted_at;
    }
    public LinkDTO() {
        
    }
    
    public LinkDTO(Link entity) {
        this.id = entity.getId();
        this.shortened_link = entity.getShortened_link();
        this.original_link = entity.getOriginal_link();
        this.updated_at = entity.getUpdated_at();
        this.created_at = entity.getCreated_at();
        this.deleted_at = entity.getDeleted_at();
    }
    public Long getId() {
        return id;
    }
    public String getShortened_link() {
        return shortened_link;
    }
    public String getOriginal_link() {
        return original_link;
    }
    public Instant getUpdated_at() {
        return updated_at;
    }
    public Instant getCreated_at() {
        return created_at;
    }
    public Instant getDeleted_at() {
        return deleted_at;
    }    
}
