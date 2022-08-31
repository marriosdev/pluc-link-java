package com.pluc.pluc.modules.User.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pluc.pluc.modules.User.entities.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

    
}
