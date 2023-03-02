package com.example.Library.repository;

import com.example.Library.model.entity.AuthorEntity;
import com.example.Library.model.enums.GenreTypeEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AuthorRepository extends JpaRepository<AuthorEntity, Long> {
    Optional<AuthorEntity> findAuthorByName (String authorName);
}
