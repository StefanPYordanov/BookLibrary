package com.example.Library.models.entity;

import com.example.Library.models.enums.RoleType;
import jakarta.persistence.*;

@Entity
@Table(name = "user-roles")
public class UserRole {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Enumerated(EnumType.STRING)
    private RoleType role;

    public UserRole() {
    }

    public long getId() {
        return id;
    }

    public UserRole setId(long id) {
        this.id = id;
        return this;
    }

    public RoleType getRole() {
        return role;
    }

    public UserRole setRole(RoleType role) {
        this.role = role;
        return this;
    }
}
