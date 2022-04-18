package com.novisign.testApp.service;

import com.novisign.testApp.domain.ProjectEntity;
import com.novisign.testApp.dto.CreateProjectRequest;
import com.novisign.testApp.dto.ProjectDto;
import com.novisign.testApp.dto.UpdateProjectRequest;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ProjectService {

    @Transactional
    Mono<ProjectEntity> create(CreateProjectRequest request);

    @Transactional(readOnly = true)
    Flux<ProjectDto> getAll();

    @Transactional(readOnly = true)
    Mono<ProjectDto> get(String name);

    @Transactional
    Mono<ProjectEntity> update(UpdateProjectRequest request, String name);

    @Transactional
    Mono<Void> delete(String name);
}
