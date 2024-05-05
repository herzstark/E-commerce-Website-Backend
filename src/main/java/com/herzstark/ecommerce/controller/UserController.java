package com.herzstark.ecommerce.controller;


import com.herzstark.ecommerce.entities.User;
import com.herzstark.ecommerce.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/user")
    public ResponseEntity<User> createUser(@RequestBody User user){
        return new ResponseEntity<>(userService.create(user), HttpStatus.CREATED);
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<User> getUser(@PathVariable("id") Long id){

        Optional<User> optionalUser = userService.findByID(id);
        if(optionalUser.isEmpty()){
            throw new RuntimeException();
        }
        return new ResponseEntity<>(optionalUser.get(),HttpStatus.OK);
    }


}
