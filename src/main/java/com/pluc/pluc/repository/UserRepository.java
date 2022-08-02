package com.pluc.pluc.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pluc.pluc.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
    
