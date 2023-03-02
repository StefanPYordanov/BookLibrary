package com.example.Library.repository;

import com.example.Library.model.entity.GenreEntity;
import com.example.Library.model.enums.GenreTypeEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GenreRepository extends JpaRepository<GenreEntity, Long> {

    @Query(value="SELECT * FROM GenreTypeEnum AS g where g = :genreName", nativeQuery=true)
    Optional<GenreEntity> findGenreByGenreName(GenreTypeEnum genreName);

}
