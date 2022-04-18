package com.novisign.testApp.service.db.impl;

import com.novisign.testApp.domain.ProjectEntity;
import com.novisign.testApp.repository.ProjectRepository;
import com.novisign.testApp.service.db.ProjectDbService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class ProjectDbServiceImpl implements ProjectDbService {

    private final ProjectRepository projectRepository;

    @Override
    public Mono<ProjectEntity> save(ProjectEntity project) {
        return projectRepository.findByName(project.getName())
                .switchIfEmpty(projectRepository.save(project));
    }

    @Override
    public Flux<ProjectEntity> getAll() {
        return projectRepository.findAll();
    }

    @Override
    public Mono<ProjectEntity> getByName(String name) {
        return projectRepository.findByName(name);
    }

    @Override
    public Mono<Void> delete(String name) {
        return projectRepository.findByName(name)
                .filter(Objects::nonNull)
                .flatMap(projectRepository::delete);
    }
}
