package com.novisign.testApp.service.db.impl;

import com.novisign.testApp.domain.ProjectEntity;
import com.novisign.testApp.repository.ProjectRepository;
import com.novisign.testApp.repository.UserRepository;
import com.novisign.testApp.service.db.UserProjectDbService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserProjectDbServiceImpl implements UserProjectDbService {

    private final UserRepository userRepository;
    private final ProjectRepository projectRepository;

    @Override
    public Mono<ProjectEntity> addUser(String projectName, String loginName) {
        return projectRepository.findByName(projectName)
                .doOnNext(project -> userRepository.findByLoginName(loginName)
                        .doOnNext(user -> user.addProject(project))
                        .doOnError(error -> log.error("User not found. Login name {}", loginName)))
                .doOnError(error -> log.error("Project not found. Name {}", projectName));
    }

    @Override
    public Mono<ProjectEntity> removeUser(String projectName, String loginName) {
        return projectRepository.findByName(projectName)
                .doOnNext(project -> userRepository.findByLoginName(loginName)
                        .doOnNext(user -> user.removeProject(project))
                        .doOnError(error -> log.error("User not found. Login name {}", loginName)))
                .doOnError(error -> log.error("Project not found. Name {}", projectName));
    }
}
