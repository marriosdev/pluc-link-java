package com.pluc.pluc.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pluc.pluc.repository.RoleRepository;
import com.pluc.pluc.repository.UserRepository;

@Service
public class UserService {
    
    @Autowired
    private UserRepository repository;

    @Autowired
    private  RoleRepository rolesRepository;

    
}
