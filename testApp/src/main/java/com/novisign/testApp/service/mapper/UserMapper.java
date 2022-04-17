package com.novisign.testApp.service.mapper;

import com.novisign.testApp.domain.UserEntity;
import com.novisign.testApp.dto.LoginRequest;
import com.novisign.testApp.dto.UserDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserEntity toEntity(LoginRequest request);

    UserDto toDto(UserEntity entity);
}
