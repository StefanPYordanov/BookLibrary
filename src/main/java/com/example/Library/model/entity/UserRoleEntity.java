package com.example.Library.model.entity;

import com.example.Library.model.enums.RoleTypeEnum;
import jakarta.persistence.*;
@Entity
@Table(name = "user-roles")
public class UserRoleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    private RoleTypeEnum role;
    public UserRoleEntity() {
    }
    public Long getId() {
        return id;
    }
    public UserRoleEntity setId(Long id) {
        this.id = id;
        return this;
    }
    public RoleTypeEnum getRole() {
        return role;
    }
    public UserRoleEntity setRole(RoleTypeEnum role) {
        this.role = role;
        return this;
    }
}
