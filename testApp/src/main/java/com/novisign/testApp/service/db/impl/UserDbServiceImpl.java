package com.novisign.testApp.service.db.impl;

import com.novisign.testApp.domain.UserEntity;
import com.novisign.testApp.repository.UserRepository;
import com.novisign.testApp.service.db.UserDbService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class UserDbServiceImpl implements UserDbService {

    private final UserRepository userRepository;

    @Override
    public Mono<UserEntity> save(UserEntity user) {
        return userRepository.findByLoginName(user.getLoginName())
                .switchIfEmpty(userRepository.save(user));
    }

    @Override
    public Mono<UserEntity> getByLoginName(String loginName) {
        return userRepository.findByLoginName(loginName);
    }

    @Override
    public Flux<UserEntity> getAll() {
        return userRepository.findAll();
    }

    @Override
    public Mono<UserEntity> delete(String loginName) {
        return userRepository.findByLoginName(loginName)
                .doOnNext(userRepository::delete);
    }
}
