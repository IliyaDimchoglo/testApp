package com.novisign.testApp.service.impl;

import com.novisign.testApp.domain.ProjectEntity;
import com.novisign.testApp.dto.CreateProjectRequest;
import com.novisign.testApp.dto.ProjectDto;
import com.novisign.testApp.dto.UpdateProjectRequest;
import com.novisign.testApp.service.ProjectService;
import com.novisign.testApp.service.db.ProjectDbService;
import com.novisign.testApp.service.mapper.ProjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProjectServiceImpl implements ProjectService {

    private final ProjectMapper mapper;
    private final ProjectDbService projectDbService;

    @Override
    public Mono<ProjectEntity> create(CreateProjectRequest request) {
        return projectDbService.save(mapper.toEntity(request));
    }

    @Override
    public Flux<ProjectDto> getAll() {
        return projectDbService.getAll().map(mapper::toDto);
    }

    @Override
    public Mono<ProjectDto> get(String name) {
        return projectDbService.getByName(name).map(mapper::toDto);
    }

    @Override
    public Mono<ProjectEntity> update(UpdateProjectRequest request, String name) {
        return projectDbService.getByName(name)
                .doOnNext(project -> project.update(request.getName(), request.getStatus()))
                .doOnSuccess(project -> log.info("Project successfully updated"))
                .doOnError(err -> log.error("Project update failed"));
    }

    @Override
    public Mono<ProjectEntity> delete(String name) {
        return projectDbService.delete(name);
    }
}
