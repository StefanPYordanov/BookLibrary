package com.example.Library.repositories;

import com.example.Library.models.entity.UserRole;
import com.example.Library.models.enums.RoleType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface UserRoleRepository extends JpaRepository <UserRole, Long> {

    Optional<UserRole> findUserRoleByRole(RoleType role);

}
