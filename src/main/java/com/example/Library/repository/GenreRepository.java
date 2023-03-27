package com.example.Library.repository;

import com.example.Library.model.entity.AuthorEntity;
import com.example.Library.model.entity.GenreEntity;
import com.example.Library.model.enums.GenreTypeEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface GenreRepository extends JpaRepository<GenreEntity, Long> {

    Optional<GenreEntity> findGenreByGenreName (GenreTypeEnum genre);

    List<GenreEntity> findAll();
}
