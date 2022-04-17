package com.novisign.testApp.controller;

import com.novisign.testApp.dto.UserProjectRequest;
import com.novisign.testApp.service.UserProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

@RestController
@RequestMapping("api/user_project")
@RequiredArgsConstructor
public class UserProjectController {

    private final UserProjectService projectService;

    @PutMapping("/add")
    public Mono<Void> add(@Valid @RequestBody UserProjectRequest request) {
        return projectService.add(request).then();
    }

    @PutMapping("/remove")
    public Mono<Void> remove(@Valid @RequestBody UserProjectRequest request) {
        return projectService.remove(request).then();
    }
}
