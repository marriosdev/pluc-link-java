package com.pluc.pluc.dto;

import java.io.Serializable;
import java.time.Instant;

import com.pluc.pluc.entities.Link;

public class LinkDTO implements Serializable {
    Long id;
    String link_encurtado;
    String link_original;
    Instant data_criacao;
    Instant data_exclusao;

    public LinkDTO() {
    }
    
    public LinkDTO(Long id, String link_encurtado, String link_original, Instant data_criacao, Instant data_exclusao) {
        this.link_encurtado = link_encurtado;
        this.link_original = link_original;
        this.data_criacao = data_criacao;
        this.data_exclusao = data_exclusao;
        this.id = id;
    }

    public LinkDTO(Link entity) {
        this.id             = entity.getId();
        this.link_encurtado = entity.getLink_encurtado();
        this.link_original  = entity.getLink_original();
        this.data_criacao   = entity.getData_criacao();
        this.data_exclusao  = entity.getData_exclusao();
    }

    public Long getId() {
        return id;
    }

    public String getLink_encurtado() {
        return link_encurtado;
    }

    public String getLink_original() {
        return link_original;
    }

    public Instant getData_criacao() {
        return data_criacao;
    }

    public Instant getData_exclusao() {
        return data_exclusao;
    }
}
