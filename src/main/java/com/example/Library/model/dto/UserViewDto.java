package com.example.Library.model.dto;

import com.example.Library.model.entity.UserEntity;
import com.example.Library.model.entity.UserRoleEntity;
import java.util.ArrayList;
import java.util.List;

public class UserViewDto {
    private Long id;
    private String username;
    private String email;
    private String fullName;
    private List<UserRoleEntity> roles = new ArrayList<>();
    public UserViewDto(UserEntity userEntity) {
    }
    public Long getId() {
        return id;
    }
    public UserViewDto setId(Long id) {
        this.id = id;
        return this;
    }
    public String getUsername() {
        return username;
    }
    public UserViewDto setUsername(String username) {
        this.username = username;
        return this;
    }
    public String getEmail() {
        return email;
    }
    public UserViewDto setEmail(String email) {
        this.email = email;
        return this;
    }
    public String getFullName() {
        return fullName;
    }
    public UserViewDto setFullName(String fullName) {
        this.fullName = fullName;
        return this;
    }
    public List<UserRoleEntity> getRoles() {
        return roles;
    }
    public UserViewDto setRoles(List<UserRoleEntity> roles) {
        this.roles = roles;
        return this;
    }
}
