package com.novisign.testApp;

import com.novisign.testApp.domain.UserEntity;
import com.novisign.testApp.dto.LoginRequest;
import com.novisign.testApp.dto.UpdateUserRequest;
import com.novisign.testApp.dto.UserDto;
import com.novisign.testApp.service.db.UserDbService;
import com.novisign.testApp.service.impl.UserServiceImpl;
import com.novisign.testApp.service.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.HashSet;

import static java.util.Objects.requireNonNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    private UserDbService userDbService;

    @Mock
    private UserMapper mapper;

    @InjectMocks
    private UserServiceImpl userService;

    private final String fullName = "fullName";
    private final String loginName = "loginName";
    private final String pass = "pass";
    private final UserEntity user = new UserEntity(fullName, loginName, pass, new HashSet<>());

    @Test
    public void loginTest() {
        when(userDbService.save(any())).thenReturn(Mono.just(user));
        when(mapper.toEntity(any())).thenReturn(user);

        Mono<UserEntity> response = userService.login(new LoginRequest(fullName, loginName, pass));

        assertEquals(requireNonNull(response.block()).getLoginName(), user.getLoginName());
        verify(userDbService, times(1)).save(any());
    }

    @Test
    public void getAllTest() {
        when(userDbService.getAll()).thenReturn(Flux.just(user));
        when(mapper.toDto(any())).thenReturn(new UserDto(loginName, fullName, null));

        Flux<UserDto> response = userService.getAll();

        assertEquals(requireNonNull(response.blockFirst()).getLoginName(), user.getLoginName());
        verify(userDbService, atLeast(1)).getAll();
    }

    @Test
    public void updateTest() {
        when(userDbService.getByLoginName(anyString())).thenReturn(Mono.just(user));

        Mono<UserEntity> updateResponse = userService.update(new UpdateUserRequest(loginName, fullName, pass), loginName);

        assertEquals(requireNonNull(updateResponse.block()).getLoginName(), user.getLoginName());
    }
}
