package com.novisign.testApp.service;

import com.novisign.testApp.domain.ProjectEntity;
import com.novisign.testApp.dto.UserProjectRequest;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Mono;

public interface UserProjectService {

    @Transactional
    Mono<ProjectEntity> add(UserProjectRequest request);

    @Transactional
    Mono<ProjectEntity> remove(UserProjectRequest request);
}
