package com.novisign.testApp.controller;

import com.novisign.testApp.dto.LoginRequest;
import com.novisign.testApp.dto.UpdateUserRequest;
import com.novisign.testApp.dto.UserDto;
import com.novisign.testApp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

@RestController
@RequestMapping("api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public Mono<Void> login(@Valid @RequestBody LoginRequest request) {
        return userService.login(request).then();
    }

    @GetMapping("/{loginName}")
    public Mono<UserDto> get(@PathVariable String loginName) {
        return userService.get(loginName);
    }

    @PutMapping("/{loginName}")
    public Mono<Void> update(@Valid @RequestBody UpdateUserRequest request, @PathVariable String loginName) {
        return userService.update(request, loginName).then();
    }

    @GetMapping
    public Flux<UserDto> getAll() {
        return userService.getAll();
    }

    @DeleteMapping("/{loginName}")
    public Mono<Void> delete(@PathVariable String loginName) {
        return userService.delete(loginName);
    }
}
