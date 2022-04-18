package com.novisign.testApp.repository;

import com.novisign.testApp.domain.ProjectEntity;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import reactor.core.publisher.Mono;

import java.util.UUID;

public interface ProjectRepository extends R2dbcRepository<ProjectEntity, UUID> {

    Mono<ProjectEntity> findByName(String name);
}
