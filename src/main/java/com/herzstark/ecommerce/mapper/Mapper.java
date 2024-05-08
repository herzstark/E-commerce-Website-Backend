package com.herzstark.ecommerce.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class Mapper<A, B> {

    @Autowired
    protected ModelMapper modelMapper;

    public abstract B mapTo(A a);

    public abstract A mapFrom(B b);
}