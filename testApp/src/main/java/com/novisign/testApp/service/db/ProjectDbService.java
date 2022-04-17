package com.novisign.testApp.service.db;

import com.novisign.testApp.domain.ProjectEntity;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ProjectDbService {

    Mono<ProjectEntity> save(ProjectEntity projectEntity);

    Flux<ProjectEntity> getAll();

    Mono<ProjectEntity> getByName(String name);

    Mono<ProjectEntity> delete(String name);
}
