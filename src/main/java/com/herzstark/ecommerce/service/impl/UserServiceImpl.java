package com.herzstark.ecommerce.service.impl;

import com.herzstark.ecommerce.entities.User;
import com.herzstark.ecommerce.repositories.UserRepository;
import com.herzstark.ecommerce.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;


    @Override
    public User create(User user) {
        user.getPassword();
        return userRepository.save(user);
    }

    @Override
    public User update(User user) {
        return userRepository.save(user);
    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);

    }

    @Override
    public Optional<User> findByID(Long id) {
        return userRepository.findById(id);
    }
}
