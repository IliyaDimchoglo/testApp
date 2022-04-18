package com.novisign.testApp.service.impl;

import com.novisign.testApp.domain.ProjectEntity;
import com.novisign.testApp.dto.UserProjectRequest;
import com.novisign.testApp.service.UserProjectService;
import com.novisign.testApp.service.db.ProjectDbService;
import com.novisign.testApp.service.db.UserDbService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserProjectServiceImpl implements UserProjectService {

    private final UserDbService userDbService;
    private final ProjectDbService projectDbService;

    @Override
    public Mono<ProjectEntity> add(UserProjectRequest request) {
        return projectDbService.getByName(request.getProjectName())
                .doOnNext(project -> userDbService.getByLoginName(request.getLoginName())
                        .doOnNext(project::addUser))
                .doOnError(error -> log.error("[x] Filed to add user to the project"));
    }

    @Override
    public Mono<ProjectEntity> remove(UserProjectRequest request) {
        return projectDbService.getByName(request.getProjectName())
                .doOnNext(project -> userDbService.getByLoginName(request.getLoginName())
                        .doOnNext(project::removeUser))
                .doOnError(error -> log.error("[x] Filed to remove user from the project"));
    }
}
