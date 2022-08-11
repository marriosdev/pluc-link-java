package com.pluc.pluc.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity 
@Table(name = "tb_role")
@EqualsAndHashCode
@NoArgsConstructor
public class Role{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Define que o valor do id sera gerenciado pelo provedor de persistencia
    private @Getter @Setter Long id;
    private @Getter @Setter String authority;
}
