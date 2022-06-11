package com.pluc.pluc.entities;

import java.time.Instant;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_link")
public class Link implements Serializable{
    
    @Id // Definindo que esse é o atributo de id 
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Define que o valor do id sera gerenciado pelo provedor de persistencia
    Long id;

    String shortened_link;
    String original_link;

    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE default now()")
    Instant updated_at;
    
    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE default now()")
    Instant created_at;
    
    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    Instant deleted_at;

    public Link(Long id, String shortened_link, String original_link, Instant created_at, Instant updated_at, Instant deleted_at) {
        this.id = id;
        this.shortened_link = generate_shortened();
        this.original_link = original_link;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.deleted_at = deleted_at;
    }

    public String generate_shortened() {
        String theAlphaNumericS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "0123456789"; 
        StringBuilder  builder = new StringBuilder(6); 

        for (int i = 0; i < 6; i++) { 
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
        return shortened_link;
    }
    public void setShortened_link(String shortened_link) {
        this.shortened_link = shortened_link;
    }
    public String getOriginal_link() {
        return original_link;
    }
    public void setOriginal_link(String original_link) {
        this.original_link = original_link;
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

    public Instant getDeleted_at() {
        return deleted_at;
    }

    public void setDeleted_at(Instant deleted_at) {
        this.deleted_at = deleted_at;
    }
}
