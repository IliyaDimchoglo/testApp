package com.novisign.testApp.service.db;

import com.novisign.testApp.domain.ProjectEntity;
import reactor.core.publisher.Mono;

public interface UserProjectDbService {

    Mono<ProjectEntity> addUser(String projectName, String loginName);

    Mono<ProjectEntity> removeUser(String projectName, String loginName);
}
