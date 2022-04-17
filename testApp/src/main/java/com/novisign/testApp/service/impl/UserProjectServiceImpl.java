package com.novisign.testApp.service.impl;

import com.novisign.testApp.domain.ProjectEntity;
import com.novisign.testApp.dto.UserProjectRequest;
import com.novisign.testApp.service.UserProjectService;
import com.novisign.testApp.service.db.ProjectDbService;
import com.novisign.testApp.service.db.UserDbService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class UserProjectServiceImpl implements UserProjectService {

    private final UserDbService userDbService;
    private final ProjectDbService projectDbService;


    @Override
    public Mono<ProjectEntity> add(UserProjectRequest request) {
        return null;
    }

    @Override
    public Mono<ProjectEntity> remove(UserProjectRequest request) {
        return null;
    }
}
