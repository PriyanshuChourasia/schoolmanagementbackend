package com.wishalpha.schoolmanagement.auth.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class LoginDTO {

    @Email(message = "Invalid email")
    @NotNull(message = "Email cannot be empty")
    @NotNull(message = "Please provide a correct email")
    private String email;

    @Size(min = 6,message = "Password cannot be less than 6 characters")
    @NotNull(message = "Password cannot be null")
    @NotBlank(message = "Password cannot be blank")
    private String password;
}
