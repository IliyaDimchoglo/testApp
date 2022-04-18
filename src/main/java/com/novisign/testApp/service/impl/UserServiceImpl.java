package com.novisign.testApp.service.impl;


import com.novisign.testApp.domain.UserEntity;
import com.novisign.testApp.dto.LoginRequest;
import com.novisign.testApp.dto.UpdateUserRequest;
import com.novisign.testApp.dto.UserDto;
import com.novisign.testApp.service.UserService;
import com.novisign.testApp.service.db.UserDbService;
import com.novisign.testApp.service.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserMapper mapper;
    private final UserDbService userDbService;

    @Override
    public Mono<UserEntity> login(LoginRequest request) {
        return userDbService.save(mapper.toEntity(request))
                .doOnSuccess(user -> log.info("User successfully saved. LoginName: {} ", user.getLoginName()));
    }

    @Override
    public Mono<UserDto> get(String loginName) {
        return userDbService.getByLoginName(loginName).map(mapper::toDto);
    }

    @Override
    public Mono<UserEntity> update(UpdateUserRequest request, String loginName) {
        return userDbService.getByLoginName(loginName)
                .doOnNext(user -> user.update(request.getFullName(), request.getLoginName(), request.getPassword()))
                .doOnSuccess(project -> log.info("Project successfully updated"))
                .doOnError(err -> log.error("Project update failed"));
    }

    @Override
    public Flux<UserDto> getAll() {
        return userDbService.getAll().map(mapper::toDto);
    }

    @Override
    public Mono<Void> delete(String loginName) {
        return userDbService.delete(loginName).doOnSuccess(e -> log.info("[x] User successfully deleted. LoginName {}", loginName));
    }
}
