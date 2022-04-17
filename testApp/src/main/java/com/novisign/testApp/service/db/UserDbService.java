package com.novisign.testApp.service.db;

import com.novisign.testApp.domain.UserEntity;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface UserDbService {

    Mono<UserEntity> save(UserEntity user);

    Mono<UserEntity> getByLoginName(String loginName);

    Flux<UserEntity> getAll();

    Mono<UserEntity> delete(String loginName);
}
