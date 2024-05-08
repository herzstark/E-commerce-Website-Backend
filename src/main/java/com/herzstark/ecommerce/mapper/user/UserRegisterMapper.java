package com.herzstark.ecommerce.mapper.user;

import com.herzstark.ecommerce.dtos.UserRegisterDTO;
import com.herzstark.ecommerce.entities.User;
import com.herzstark.ecommerce.mapper.Mapper;
import org.modelmapper.ModelMapper;

public class UserRegisterMapper extends Mapper<User, UserRegisterDTO> {


    @Override
    public UserRegisterDTO mapTo(User user) {

        return modelMapper.map(user,UserRegisterDTO.class);
    }

    @Override
    public User mapFrom(UserRegisterDTO userRegisterDTO) {
        return modelMapper.map(userRegisterDTO, User.class);
    }
}
