package com.example.Library.service;

import com.example.Library.model.dto.AddAuthorDto;
import com.example.Library.model.entity.AuthorEntity;
import com.example.Library.repository.AuthorRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;


@ExtendWith(MockitoExtension.class)
public class AuthorServiceTest {
    private AuthorService toTest;
    @Mock
    private AuthorRepository mockAuthorRepository;
    @Captor
    private ArgumentCaptor<AuthorEntity> authorEntityCaptor;

    @BeforeEach
    void setUp() {
        toTest = new AuthorService(mockAuthorRepository);
    }

    @Test
    void testAddAuthor(){
        AddAuthorDto testAddAuthorDto = new AddAuthorDto()
                .setName("Test")
                .setNationality("Bulgaria")
                .setYearOfBirth(2013L);

        toTest.addAuthor(testAddAuthorDto);


        verify(mockAuthorRepository).save(authorEntityCaptor.capture());

        AuthorEntity savedAuthor = authorEntityCaptor.getValue();

        Assertions.assertEquals(testAddAuthorDto.getName(), savedAuthor.getName());
        Assertions.assertEquals(testAddAuthorDto.getNationality(), savedAuthor.getNationality());
        Assertions.assertEquals(testAddAuthorDto.getYearOfBirth(), savedAuthor.getYearOfBirth());


    }
}
