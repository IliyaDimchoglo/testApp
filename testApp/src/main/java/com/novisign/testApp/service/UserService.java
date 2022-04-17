package com.novisign.testApp.service;

import com.novisign.testApp.domain.UserEntity;
import com.novisign.testApp.dto.LoginRequest;
import com.novisign.testApp.dto.UpdateUserRequest;
import com.novisign.testApp.dto.UserDto;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface UserService {

    @Transactional
    Mono<UserEntity> login(LoginRequest request);

    Mono<UserDto> get(String loginName);

    Mono<UserEntity> update(UpdateUserRequest request, String loginName);

    Flux<UserDto> getAll();

    Mono<UserEntity> delete(String loginName);
}
