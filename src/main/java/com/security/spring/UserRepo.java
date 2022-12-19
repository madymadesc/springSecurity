package com.security.spring;

import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo {
    Optional<User> findByUsername(String username);
}
