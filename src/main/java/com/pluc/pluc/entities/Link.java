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

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Entity
@Table(name = "tb_link")
@SQLDelete(sql = "UPDATE tb_link SET deleted_at = true WHERE id=?")
@Where(clause = "deleted_at=false")
public class Link{
    
    @Id // Definindo que esse é o atributo de id 
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Define que o valor do id sera gerenciado pelo provedor de persistencia
    @Getter @Setter  Long id;

    @Column(unique=true)
    @Getter @Setter  String shortenedLink;

    @Getter @Setter  String originalLink;

    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE default now()")
    @Getter @Setter  Instant updatedAt;
    
    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE default now()")
    @Getter @Setter  Instant createdAt;
    
    @Getter @Setter  Boolean deletedAt = Boolean.FALSE;

    public Link(Long id, String shortenedLink, String originalLink, Instant createdAt, Instant updatedAt, Boolean deletedAt) {
        this.id             = id;
        this.shortenedLink  = shortenedLink;
        this.originalLink   = originalLink;
        this.createdAt      = createdAt;
        this.updatedAt      = updatedAt;
        this.deletedAt      = deletedAt;
    }
}
