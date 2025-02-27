package com.avanade.rest_api.services.impl;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.avanade.rest_api.models.User;
import com.avanade.rest_api.repositories.UserRepository;
import com.avanade.rest_api.services.UserService;

@Service
public class UserServiceImpl  implements UserService {

    @Autowired
    private UserRepository repository;

    @Override
    public User findById(Long id) {
        return repository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public User create(User userToCreate) {
        if(repository.existsByAccountNumber(userToCreate.getAccount().getNumber())) {
            throw new IllegalArgumentException("Já existe um usuário com esse número de conta");
        }

        return repository.save(userToCreate);
    }
    
}
