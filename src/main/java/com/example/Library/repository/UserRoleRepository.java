package com.example.Library.repository;

import com.example.Library.model.entity.UserRoleEntity;
import com.example.Library.model.enums.RoleTypeEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface UserRoleRepository extends JpaRepository <UserRoleEntity, Long> {

    List<UserRoleEntity> findUserRoleByRole(RoleTypeEnum role);

}
