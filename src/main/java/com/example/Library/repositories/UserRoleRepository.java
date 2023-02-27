package com.example.Library.repositories;

import com.example.Library.models.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRoleRepository extends JpaRepository <UserRole, Long> {

}
