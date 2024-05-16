package com.herzstark.ecommerce.service.impl;

import com.herzstark.ecommerce.entities.user.User;
import com.herzstark.ecommerce.repositories.userRepo.UserRepository;
import com.herzstark.ecommerce.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Autowired
    private UserRepository userRepository;


    @Override
    public User register(User user) {
        if(!userRepository.existsByEmail(user.getEmail()))
            throw new RuntimeException();

        if(!userRepository.existsByUsername(user.getUsername()))
            throw new RuntimeException();

        user.setPassword(passwordEncoder.encode(user.getPassword()));

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

    @Override
    public Optional<User> login(String username, String password) {

        Optional<User> userOptional = userRepository.getUserByUsername(username);
        if(userOptional.isEmpty())
            throw new RuntimeException();

        if(!passwordEncoder.matches(password,userOptional.get().getPassword()))
            throw new RuntimeException();
        return userOptional;

    }

}
