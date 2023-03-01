package com.example.Library.repository;

import com.example.Library.model.entity.UserRoleEntity;
import com.example.Library.model.enums.RoleTypeEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface UserRoleRepository extends JpaRepository <UserRoleEntity, Long> {

    Optional<UserRoleEntity> findUserRoleByRole(RoleTypeEnum role);

}
