package com.herzstark.ecommerce.mapper.user;

import com.herzstark.ecommerce.dtos.UserLoginDTO;
import com.herzstark.ecommerce.entities.User;
import com.herzstark.ecommerce.mapper.Mapper;

public class UserLoginMapper extends Mapper<User, UserLoginDTO> {

    @Override
    public UserLoginDTO mapTo(User user) {
        return modelMapper.map(user, UserLoginDTO.class);
    }

    @Override
    public User mapFrom(UserLoginDTO userLoginDTO) {
        return modelMapper.map(userLoginDTO, User.class);
    }
}
