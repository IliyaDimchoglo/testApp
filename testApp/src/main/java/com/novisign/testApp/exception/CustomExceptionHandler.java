package com.novisign.testApp.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.reactive.function.server.EntityResponse;
import reactor.core.publisher.Mono;

@Slf4j
@RestControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(Throwable.class)
    public Mono<EntityResponse<String>> baseExceptionHandler(Throwable throwable){
        log.error(throwable.getMessage());
        return EntityResponse.fromObject("Something gone wrong").status(HttpStatus.BAD_REQUEST).build();
    }
}
