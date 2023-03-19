package com.example.Library.service;

import com.example.Library.model.dto.AddBookDto;
import com.example.Library.model.dto.BookViewDto;
import com.example.Library.model.dto.RegistrationDto;
import com.example.Library.model.entity.BookEntity;
import com.example.Library.model.entity.UserEntity;
import com.example.Library.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BookService {

    private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<BookEntity> getAlLBooks() {
        return this.bookRepository
                .findAll();
    }

    public void addBook(AddBookDto addBookDto) {

        BookEntity book = new BookEntity(
                addBookDto.getName(),
                addBookDto.getAuthor(),
                addBookDto.getGenre(),
                addBookDto.getReleaseYear(),
                addBookDto.getPages()
        );

        this.bookRepository.save(book);
    }

    public List<BookViewDto> getAllBooks() {
        return bookRepository.findAll().stream().map(book -> new BookViewDto(
                book.getId(),
                book.getName(),
                book.getAuthor(),
                book.getGenre(),
                book.getReleaseYear(),
                book.getPages()
        )).collect(Collectors.toList());
    }

    public BookViewDto getBook(Long id) {
        return bookRepository.findById(id).map(book -> new BookViewDto(
                book.getId(),
                book.getName(),
                book.getAuthor(),
                book.getGenre(),
                book.getReleaseYear(),
                book.getPages()
        )).orElseThrow(RuntimeException::new);
    }
}

