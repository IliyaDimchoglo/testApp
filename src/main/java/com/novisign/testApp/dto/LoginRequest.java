package com.novisign.testApp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginRequest {

    @NotBlank(message = "Full name is empty")
    private String fullName;

    @NotBlank(message = "Login name is empty")
    private String loginName;

    @NotBlank(message = "Password is empty")
    private String password;
}
