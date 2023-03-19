package com.example.Library.model.dto;

import com.example.Library.model.entity.AuthorEntity;
import com.example.Library.model.entity.GenreEntity;

public class BookViewDto {
    private Long id;

    private String name;

    private String author;

    private String genre;

    private long releaseYear;

    private long pages;

    public BookViewDto() {
    }


    public BookViewDto(Long id, String name, AuthorEntity author, GenreEntity genre, long releaseYear, long pages) {
    }

    public Long getId() {
        return id;
    }

    public BookViewDto setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public BookViewDto setName(String name) {
        this.name = name;
        return this;
    }

    public String getAuthor() {
        return author;
    }

    public BookViewDto setAuthor(String author) {
        this.author = author;
        return this;
    }

    public String getGenre() {
        return genre;
    }

    public BookViewDto setGenre(String genre) {
        this.genre = genre;
        return this;
    }

    public long getReleaseYear() {
        return releaseYear;
    }

    public BookViewDto setReleaseYear(long releaseYear) {
        this.releaseYear = releaseYear;
        return this;
    }

    public long getPages() {
        return pages;
    }

    public BookViewDto setPages(long pages) {
        this.pages = pages;
        return this;
    }
}
