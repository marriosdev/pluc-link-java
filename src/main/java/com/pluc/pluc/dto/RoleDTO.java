package com.pluc.pluc.dto;

import java.io.Serializable;

import org.hibernate.event.spi.PostUpdateEvent;

import com.pluc.pluc.entities.Role;


public class RoleDTO implements Serializable{

    private Long id;
    private String authority;
    
    public RoleDTO() {
    }

    public RoleDTO(Long id, String authority) {
        this.id = id;
        this.authority = authority;
    }
    
    public RoleDTO(Role role) {
        id = role.getId();
        authority = role.getAuthority();
    }

    public Long getId() {
        return id;
    }

    public String getAuthority() {
        return authority;
    }

}
