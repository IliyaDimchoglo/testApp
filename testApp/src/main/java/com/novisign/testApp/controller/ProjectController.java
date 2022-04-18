package com.novisign.testApp.controller;

import com.novisign.testApp.domain.ProjectEntity;
import com.novisign.testApp.dto.CreateProjectRequest;
import com.novisign.testApp.dto.ProjectDto;
import com.novisign.testApp.dto.UpdateProjectRequest;
import com.novisign.testApp.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

@RestController
@RequestMapping("api/projects")
@RequiredArgsConstructor
public class ProjectController {

    private final ProjectService projectService;

    @GetMapping
    public Flux<ProjectDto> getAll(){
        return projectService.getAll();
    }

    @GetMapping("/{name}")
    public Mono<ProjectDto> get(@PathVariable String name){
        return projectService.get(name);
    }

    @PutMapping("/{name}")
    public Mono<Void> update(@Valid @RequestBody UpdateProjectRequest request, @PathVariable String name){
        return projectService.update(request, name).then();
    }

    @DeleteMapping("/{name}")
    public Mono<Void>  delete(@PathVariable String name) {
        return projectService.delete(name);
    }

    @PostMapping
    public Mono<Void> create(@Valid @RequestBody CreateProjectRequest request) {
        return projectService.create(request).then();
    }
}
