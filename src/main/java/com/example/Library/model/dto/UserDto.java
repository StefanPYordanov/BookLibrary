package com.example.Library.model.dto;
public class UserDto {
    private Long id;
    private String username;
    private String email;
    private String fullName;
    public UserDto() {
    }
    public Long getId() {
        return id;
    }
    public UserDto setId(Long id) {
        this.id = id;
        return this;
    }
    public String getUsername() {
        return username;
    }
    public UserDto setUsername(String username) {
        this.username = username;
        return this;
    }
    public String getEmail() {
        return email;
    }
    public UserDto setEmail(String email) {
        this.email = email;
        return this;
    }
    public String getFullName() {
        return fullName;
    }
    public UserDto setFullName(String fullName) {
        this.fullName = fullName;
        return this;
    }
}
