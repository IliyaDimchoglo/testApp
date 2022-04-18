package com.novisign.testApp.service.mapper;

import com.novisign.testApp.domain.UserEntity;
import com.novisign.testApp.dto.LoginRequest;
import com.novisign.testApp.dto.UserDto;
import java.time.Instant;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-04-18T19:22:21+0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 1.8.0_202 (Oracle Corporation)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public UserEntity toEntity(LoginRequest request) {
        if ( request == null ) {
            return null;
        }

        UserEntity userEntity = new UserEntity();

        userEntity.setFullName( request.getFullName() );
        userEntity.setLoginName( request.getLoginName() );
        userEntity.setPassword( request.getPassword() );

        userEntity.setCreatedTime( Instant.now() );
        userEntity.setUpdatedTime( Instant.now() );

        return userEntity;
    }

    @Override
    public UserDto toDto(UserEntity entity) {
        if ( entity == null ) {
            return null;
        }

        UserDto userDto = new UserDto();

        userDto.setLoginName( entity.getLoginName() );
        userDto.setFullName( entity.getFullName() );

        return userDto;
    }
}
