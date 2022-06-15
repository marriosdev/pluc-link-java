package com.pluc.pluc.entities;

import java.time.Instant;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

@Entity
@Table(name = "tb_link")
@SQLDelete(sql = "UPDATE tb_link SET deleted = true WHERE id=?")
@Where(clause = "deleted=false")
public class Link implements Serializable{
    
    @Id // Definindo que esse é o atributo de id 
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Define que o valor do id sera gerenciado pelo provedor de persistencia
    Long id;

    @Column(unique=true)
    String shortenedLink;

    String originalLink;

    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE default now()")
    Instant updated_at;
    
    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE default now()")
    Instant created_at;
    
    Boolean deleted = Boolean.FALSE;

    public Link(Long id, String shortenedLink, String originalLink, Instant created_at, Instant updated_at, Boolean deleted) {
        this.id = id;
        this.shortenedLink  = generate_shortened();
        this.originalLink   = originalLink;
        this.created_at     = created_at;
        this.updated_at     = updated_at;
        this.deleted        = deleted;
    }

    public String generate_shortened() {
        String theAlphaNumericS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890"; 
        StringBuilder  builder = new StringBuilder(10); 

        for (int i = 0; i < 10; i++) { 
            int myindex  = (int)(theAlphaNumericS.length() * Math.random()); 
            builder.append(theAlphaNumericS.charAt(myindex)); 
        } 
        return new String(builder);
    }

    public Link() {

    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getShortened_link() {
        return shortenedLink;
    }
    public void setShortened_link(String shortenedLink) {
        this.shortenedLink = generate_shortened();
    }
    public String getOriginal_link() {
        return originalLink;
    }
    public void setOriginal_link(String originalLink) {
        this.originalLink = originalLink;
    }
    public Instant getUpdated_at() {
        return updated_at;
    }
    public void setUpdated_at(Instant updated_at) {
        this.updated_at = updated_at;
    }
    public Instant getCreated_at() {
        return created_at;
    }
    public void setCreated_at(Instant created_at) {
        this.created_at = created_at;
    }
    public Boolean getDeleted_at() {
        return deleted ;
    }
    public void setDeleted(Boolean deleted ) {
        this.deleted = deleted;
    }
}
