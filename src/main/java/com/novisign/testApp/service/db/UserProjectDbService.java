package com.novisign.testApp.service.db;

import com.novisign.testApp.domain.ProjectEntity;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Mono;

public interface UserProjectDbService {

    @Transactional
    Mono<ProjectEntity> addUser(String projectName, String loginName);

    @Transactional
    Mono<ProjectEntity> removeUser(String projectName, String loginName);
}
