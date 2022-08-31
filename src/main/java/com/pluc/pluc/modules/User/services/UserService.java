package com.pluc.pluc.modules.User.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pluc.pluc.modules.User.repository.RoleRepository;
import com.pluc.pluc.modules.User.repository.UserRepository;

@Service
public class UserService {
    
    @Autowired
    private UserRepository repository;

    @Autowired
    private  RoleRepository rolesRepository;

    
}
