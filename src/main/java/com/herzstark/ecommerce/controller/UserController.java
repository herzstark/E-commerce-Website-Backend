package com.herzstark.ecommerce.controller;


import com.herzstark.ecommerce.dtos.UserLoginDTO;
import com.herzstark.ecommerce.dtos.UserRegisterDTO;
import com.herzstark.ecommerce.entities.user.User;
import com.herzstark.ecommerce.mapper.Mapper;
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
    @Autowired
    private Mapper<User, UserRegisterDTO> mapper;

    @PostMapping("/public/user/register")
    public ResponseEntity<User> registerUser(@RequestBody UserRegisterDTO userRegisterDTO){

        return new ResponseEntity<>(userService.register(mapper.mapFrom(userRegisterDTO)),HttpStatus.CREATED);
    }

    @PostMapping("/public/user/login")
    public ResponseEntity<User> loginUser(@RequestBody UserLoginDTO userLoginDTO){
        String userPassword = userLoginDTO.getPassword();
        String username = userLoginDTO.getUsername();

        return new ResponseEntity<>(userService.login(username,userPassword).get(), HttpStatus.OK);
    }

    @GetMapping("/public/user/{id}")
    public ResponseEntity<User> getUser(@PathVariable("id") Long id){

        Optional<User> optionalUser = userService.findByID(id);
        if(optionalUser.isEmpty()){
            throw new RuntimeException();
        }
        return new ResponseEntity<>(optionalUser.get(),HttpStatus.OK);
    }
    @PutMapping("/private/user/{id}")
    public ResponseEntity<User> updateUser(@PathVariable("id") Long id ,@RequestBody User user){
        user.setId(id);
        return new ResponseEntity<>(userService.update(user),HttpStatus.OK);
    }
    @DeleteMapping("/private/user/{id}")
    public ResponseEntity deleteUser(@PathVariable("id") Long id){
        userService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
