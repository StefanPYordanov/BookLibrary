package com.example.Library.repository;

import com.example.Library.model.entity.UserEntity;
import com.example.Library.model.entity.UserRoleEntity;
import com.example.Library.service.ApplicationUserDetailsService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
   Optional<UserEntity> findUserEntityByUsername (String username);

   Optional<UserEntity> findByEmail (String email);

   Optional<UserEntity> findUserEntityById (Long id);









}
