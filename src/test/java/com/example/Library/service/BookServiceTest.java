package com.example.Library.service;

import com.example.Library.model.dto.AddBookDto;
import com.example.Library.model.dto.BookViewDto;
import com.example.Library.model.entity.AuthorEntity;
import com.example.Library.model.entity.BookEntity;
import com.example.Library.model.entity.GenreEntity;
import com.example.Library.model.enums.GenreTypeEnum;
import com.example.Library.repository.BookRepository;
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
import java.util.Optional;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class BookServiceTest {
    private BookService toTest;
    @Mock
    private BookRepository mockBookRepository;
    @Captor
    private ArgumentCaptor<BookEntity> bookEntityCaptor;

    @BeforeEach
    void setUp() {
        toTest = new BookService(mockBookRepository);
    }

    @Test
    void testAddingABook(){
        AddBookDto testAddBookDto = new AddBookDto()
                .setName("Test Book")
                .setAuthor(new AuthorEntity().setName("Test"))
                .setGenre(new GenreEntity().setGenreName(GenreTypeEnum.Fantasy))
                .setReleaseYear(2013L)
                .setPages(100L);

        toTest.addBook(testAddBookDto);

        verify(mockBookRepository).save(bookEntityCaptor.capture());

        BookEntity savedBook = bookEntityCaptor.getValue();

        Assertions.assertEquals(testAddBookDto.getName(), savedBook.getName());
        Assertions.assertEquals(testAddBookDto.getAuthor(), savedBook.getAuthor());
        Assertions.assertEquals(testAddBookDto.getGenre(), savedBook.getGenre());
        Assertions.assertEquals(testAddBookDto.getReleaseYear(), savedBook.getReleaseYear());
        Assertions.assertEquals(testAddBookDto.getPages(), savedBook.getPages());
    }

    @Test
    void testGetOneBook(){
        BookEntity testBookEntity = new BookEntity()
                .setId(1L)
                .setName("Test Book")
                .setAuthor(new AuthorEntity().setName("Test"))
                .setGenre(new GenreEntity().setGenreName(GenreTypeEnum.Fantasy))
                .setReleaseYear(2013L)
                .setPages(100L)
                .setRating(0L);

        when(mockBookRepository.findById(1L)).thenReturn(Optional.of(testBookEntity));

        BookEntity entity = toTest.getOneBook(1L);

        BookEntity findedBook = mockBookRepository.findById(1L).orElseThrow();

        Assertions.assertEquals(entity.getName(), findedBook.getName());

    }

    @Test
    void testRateBook(){
        BookEntity testBookEntity = new BookEntity()
                .setId(1L)
                .setName("Test Book")
                .setAuthor(new AuthorEntity().setName("Test"))
                .setGenre(new GenreEntity().setGenreName(GenreTypeEnum.Fantasy))
                .setReleaseYear(2013L)
                .setPages(100L)
                .setRating(0L);

        when(mockBookRepository.findById(1L)).thenReturn(Optional.of(testBookEntity));

        BookEntity findedBook = mockBookRepository.findById(1L).orElseThrow();

        toTest.rate(1L);

        verify(mockBookRepository).save(findedBook);

        Assertions.assertEquals(1L, findedBook.getRating());
    }
}
