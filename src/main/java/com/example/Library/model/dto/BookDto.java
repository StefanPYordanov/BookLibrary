package com.example.Library.model.dto;

import com.example.Library.model.entity.AuthorEntity;
import com.example.Library.model.entity.GenreEntity;
public class BookDto {
    private Long id;
    private String name;
    private AuthorEntity author;
    private GenreEntity genre;
    private long releaseYear;
    private long pages;
    public BookDto() {
    }
    public Long getId() {
        return id;
    }
    public BookDto setId(Long id) {
        this.id = id;
        return this;
    }
    public String getName() {
        return name;
    }
    public BookDto setName(String name) {
        this.name = name;
        return this;
    }
    public AuthorEntity getAuthor() {
        return author;
    }
    public BookDto setAuthor(AuthorEntity author) {
        this.author = author;
        return this;
    }
    public GenreEntity getGenre() {
        return genre;
    }
    public BookDto setGenre(GenreEntity genre) {
        this.genre = genre;
        return this;
    }
    public long getReleaseYear() {
        return releaseYear;
    }
    public BookDto setReleaseYear(long releaseYear) {
        this.releaseYear = releaseYear;
        return this;
    }
    public long getPages() {
        return pages;
    }
    public BookDto setPages(long pages) {
        this.pages = pages;
        return this;
    }
}
