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
import java.util.ArrayList;
import java.util.List;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
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
                .setNationality("Bulgarian")
                .setYearOfBirth(2013L);
        toTest.addAuthor(testAddAuthorDto);
        verify(mockAuthorRepository).save(authorEntityCaptor.capture());
        AuthorEntity savedAuthor = authorEntityCaptor.getValue();
        Assertions.assertEquals(testAddAuthorDto.getName(), savedAuthor.getName());
        Assertions.assertEquals(testAddAuthorDto.getNationality(), savedAuthor.getNationality());
        Assertions.assertEquals(testAddAuthorDto.getYearOfBirth(), savedAuthor.getYearOfBirth());
    }
    @Test
    void testGetAllAuthors(){
        AuthorEntity testAuthor = new AuthorEntity()
                .setName("Test")
                .setNationality("Bulgarian")
                .setYearOfBirth(2013L);
        AuthorEntity testAuthor2 = new AuthorEntity()
                .setName("Test2")
                .setNationality("British")
                .setYearOfBirth(2018L);
        List<AuthorEntity> listOfAuthors = new ArrayList<>();
        listOfAuthors.add(testAuthor);
        listOfAuthors.add(testAuthor2);
        when(mockAuthorRepository.findAll()).thenReturn(listOfAuthors);
        List<AuthorEntity> listOfAllAuthorsReturnedByRepository = toTest.getAllAuthors();
        Assertions.assertEquals(2, listOfAllAuthorsReturnedByRepository.size());
    }
    @Test
    void testGetAllBooks(){
        AuthorEntity testAuthor = new AuthorEntity()
                .setId(1L)
                .setName("Test Author")
                .setNationality("British")
                .setYearOfBirth(2018L);
        AuthorEntity testAuthor2 = new AuthorEntity()
                .setId(2L)
                .setName("Test")
                .setNationality("Bulgarian")
                .setYearOfBirth(2013L);
        List<AuthorEntity> listOfAllAuthors = new ArrayList<>();
        listOfAllAuthors.add(testAuthor);
        listOfAllAuthors.add(testAuthor2);
        when(mockAuthorRepository.findAll()).thenReturn(listOfAllAuthors);
        List<AddAuthorDto> listOfAllBooksReturnedByRepository = toTest.getAuthors();
        Assertions.assertEquals(2, listOfAllBooksReturnedByRepository.size());
    }
}
