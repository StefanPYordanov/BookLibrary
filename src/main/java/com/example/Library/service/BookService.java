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

        BookEntity book = new BookEntity()
                .setName(addBookDto.getName())
                .setAuthor(addBookDto.getAuthor())
                .setGenre(addBookDto.getGenre())
                .setReleaseYear(addBookDto.getReleaseYear())
                .setPages(addBookDto.getPages());


        this.bookRepository.save(book);
    }

/*    public List<BookViewDto> getAllBooks() {
        return bookRepository.findAll().stream().map(book -> new BookViewDto(
                book.getId(),
                book.getName(),
                book.getAuthor(),
                book.getGenre(),
                book.getReleaseYear(),
                book.getPages()
        )).collect(Collectors.toList());
    }*/

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


    public List<BookViewDto> getAllBooks() {
        return
                bookRepository.
                        findAll().
                        stream().
                        map(this::map).
                        toList();
    }

    private BookViewDto map(BookEntity bookEntity) {
        return new BookViewDto()
                .setId(bookEntity.getId())
                .setName(bookEntity.getName())
                .setAuthor(bookEntity.getAuthor().getName())
                .setGenre(bookEntity.getGenre().getGenreName().toString())
                .setReleaseYear(bookEntity.getReleaseYear())
                .setPages(bookEntity.getPages())
                .setRating(bookEntity.getRating());

    }

    public BookEntity getOneBook(long id) {
        return bookRepository
                    .findById(id)
                    .orElseThrow(IllegalArgumentException::new);
    }

    public BookEntity rate(long id){
        BookEntity book = getOneBook(id);

        book.setRating(book.getRating() + 1);

        return bookRepository.save(book);
    }



}


