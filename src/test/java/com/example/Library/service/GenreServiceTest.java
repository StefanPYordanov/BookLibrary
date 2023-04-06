package com.example.Library.service;

import com.example.Library.model.entity.GenreEntity;
import com.example.Library.model.entity.UserEntity;
import com.example.Library.model.enums.GenreTypeEnum;
import com.example.Library.repository.GenreRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class GenreServiceTest {

    private GenreService toTest;

    @Mock
    private GenreRepository mockGenreRepository;

    @BeforeEach
    void setUp() {
        toTest = new GenreService (mockGenreRepository);
    }

    @Test
    void testGetAllGenres(){
        GenreEntity testGenre = new GenreEntity()
                .setId(1L)
                .setGenreName(GenreTypeEnum.Fantasy)
                .setDescription("test fantasy");

        GenreEntity testGenre2 = new GenreEntity()
                .setId(2L)
                .setGenreName(GenreTypeEnum.SciFi)
                .setDescription("test SciFi");

        List<GenreEntity> listOfGenres = new ArrayList<>();

        listOfGenres.add(testGenre);
        listOfGenres.add(testGenre2);

        when(mockGenreRepository.findAll()).thenReturn(listOfGenres);

        List<GenreEntity> listOfAllGenresReturnedByRepository = toTest.getAllGenres();

        Assertions.assertEquals(2, listOfAllGenresReturnedByRepository.size());
    }
}
