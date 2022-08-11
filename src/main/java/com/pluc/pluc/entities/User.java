package com.pluc.pluc.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity 
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Table(name = "tb_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Define que o valor do id sera gerenciado pelo provedor de persistencia
    private @Getter @Setter  Long id;   
    private @Getter @Setter  String firstName;
    private @Getter @Setter  String lastName;
    private @Getter @Setter  String email;
    private @Getter @Setter  String password;
    
    @ManyToMany(fetch = FetchType.EAGER) // FetchType.EAGER indica que o relacionamento sera carregado junto com o objeto principal. FetchType.LAZY indica que o relacionamento sera carregado apenas quando for necessario.
    @JoinTable(name = "tb_user_role",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
            )
    private @Getter @Setter Set<Role> roles = new HashSet<>();
}
