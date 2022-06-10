package com.pluc.pluc.entities;

import java.time.Instant;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.pluc.pluc.dto.LinkDTO;

@Entity
@Table(name = "tb_link")
public class Link implements Serializable{
    @Id // Definindo que esse é o atributo de id 
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Define que o valor do id sera gerenciado pelo provedor de persistencia
    Long id;
    String link_encurtado;
    String link_original;

    @Column(columnDefinition =  "TIMESTAMP WITHOUT TIME ZONE")
    Instant data_criacao;
    
    @Column(columnDefinition =  "TIMESTAMP WITHOUT TIME ZONE")
    Instant data_exclusao;

    public Link(Long id, String link_encurtado, String link_original, Instant data_criacao, Instant data_exclusao) {
        this.id = id;
        this.link_encurtado = link_encurtado;
        this.link_original = link_original;
        this.data_criacao = data_criacao;
        this.data_exclusao = data_exclusao;
    }
    public Link() {

    }
    
    public Long getId() {
        return id;
    }
    public String getLink_encurtado() {
        return link_encurtado;
    }
    public void setLink_encurtado(String link_encurtado) {
        this.link_encurtado = link_encurtado;
    }
    public String getLink_original() {
        return link_original;
    }
    public void setLink_original(String link_original) {
        this.link_original = link_original;
    }
    public Instant getData_criacao() {
        return data_criacao;
    }

    public Instant getData_exclusao() {
        return data_exclusao;
    }
}
