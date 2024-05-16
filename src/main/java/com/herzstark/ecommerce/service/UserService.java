package com.herzstark.ecommerce.service;

import com.herzstark.ecommerce.entities.user.User;

import java.util.Optional;

public interface UserService {

    User register(User user);

    User update(User user);

    void delete(Long id);

    Optional<User> findByID(Long id);

    Optional<User> login(String username, String password);
}
