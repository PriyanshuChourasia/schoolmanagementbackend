package com.wishalpha.schoolmanagement.auth.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class LoginDTO {

    @Schema(example = "admin@admin.com")
    @Email(message = "Invalid email")
    @NotNull(message = "Email cannot be empty")
    @NotNull(message = "Please provide a correct email")
    private String email;

    @Schema(example = "1234567890")
    @Size(min = 6,message = "Password cannot be less than 6 characters")
    @NotNull(message = "Password cannot be null")
    @NotBlank(message = "Password cannot be blank")
    private String password;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
