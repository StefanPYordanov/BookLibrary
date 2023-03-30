package com.example.Library.model.dto;

import com.example.Library.validations.PasswordMatch;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class RegistrationDto {

    @NotNull
    @Size(min = 4, max = 20)
    private String username;

    @NotBlank
    @Email
    private String email;

    @NotNull
    @Size(min = 6, max = 20)
    private String password;

    @NotNull
    @Size(min = 6, max = 20)
    private String repeatPassword;

    @NotNull
    @Size(min = 5, max = 50)
    private String fullName;


    public RegistrationDto() {
    }

    public String getUsername() {
        return username;
    }

    public RegistrationDto setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public RegistrationDto setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public RegistrationDto setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getRepeatPassword() {
        return repeatPassword;
    }

    public RegistrationDto setRepeatPassword(String repeatPassword) {
        this.repeatPassword = repeatPassword;
        return this;
    }

    public String getFullName() {
        return fullName;
    }

    public RegistrationDto setFullName(String fullName) {
        this.fullName = fullName;
        return this;
    }

    @Override
    public String toString() {
        return "RegistrationDto{" +
                "username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", repeatPassword='" + repeatPassword + '\'' +
                ", fullName='" + fullName + '\'' +
                '}';
    }
}
