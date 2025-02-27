package com.avanade.rest_api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.avanade.rest_api.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

    boolean existsByAccountNumber(String accountNumber);
}
