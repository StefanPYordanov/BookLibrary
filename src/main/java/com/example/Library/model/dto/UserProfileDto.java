package com.example.Library.model.dto;
public class UserProfileDto {
    String username;
    String fullName;
    String email;
    public UserProfileDto() {
    }
    public UserProfileDto(String username, String email, String fullName) {
    }
    public String getUsername() {
        return username;
    }
    public UserProfileDto setUsername(String username) {
        this.username = username;
        return this;
    }
    public String getFullName() {
        return fullName;
    }
    public UserProfileDto setFullName(String fullName) {
        this.fullName = fullName;
        return this;
    }
    public String getEmail() {
        return email;
    }
    public UserProfileDto setEmail(String email) {
        this.email = email;
        return this;
    }
}
