package com.novisign.testApp.service.mapper;

import com.novisign.testApp.domain.UserEntity;
import com.novisign.testApp.dto.LoginRequest;
import com.novisign.testApp.dto.UserDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.time.Instant;

@Mapper(componentModel = "spring", imports = Instant.class)
public interface UserMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdTime", expression = "java(Instant.now())")
    @Mapping(target = "updatedTime", expression = "java(Instant.now())")
    UserEntity toEntity(LoginRequest request);

    UserDto toDto(UserEntity entity);
}
