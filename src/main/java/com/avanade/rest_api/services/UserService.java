package com.avanade.rest_api.services;

import com.avanade.rest_api.models.User;

public interface UserService {

    User findById(Long id);

    User create(User userToCreate);
}
