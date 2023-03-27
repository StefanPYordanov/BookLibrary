package com.example.Library.service;

import com.example.Library.model.entity.AuthorEntity;
import com.example.Library.model.entity.GenreEntity;
import com.example.Library.repository.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenreService {
    private final GenreRepository genreRepository;

    @Autowired
    public GenreService(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }

    public List<GenreEntity> getAllGenres () {
        return genreRepository.findAll();
    }
}
