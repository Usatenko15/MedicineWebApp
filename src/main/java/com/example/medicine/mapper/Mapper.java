package com.example.medicine.mapper;

import org.mapstruct.DecoratedWith;
import org.springframework.context.annotation.Primary;

@org.mapstruct.Mapper
@Primary
@DecoratedWith(Mapper.class)
public abstract class Mapper {

}
