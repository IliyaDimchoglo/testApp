package com.novisign.testApp.service;

import com.novisign.testApp.domain.ProjectEntity;
import com.novisign.testApp.dto.UserProjectRequest;
import reactor.core.publisher.Mono;

public interface UserProjectService {

    Mono<ProjectEntity> add(UserProjectRequest request);

    Mono<ProjectEntity> remove(UserProjectRequest request);
}
