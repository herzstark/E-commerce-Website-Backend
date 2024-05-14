package com.herzstark.ecommerce.repositories;

import com.herzstark.ecommerce.entities.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    Optional<User> getUserByUsername(String username);
    boolean existsByUsername(String username);
    boolean existsByEmail(String email);
}
