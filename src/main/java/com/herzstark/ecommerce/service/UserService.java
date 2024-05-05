package com.herzstark.ecommerce.service;

import com.herzstark.ecommerce.entities.User;

import java.util.Optional;

public interface UserService {

    User create(User user);

    User update(User user);

    void delete(Long id);

    Optional<User> findByID(Long id);
}
