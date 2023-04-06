package com.example.Library.model.dto;

import com.example.Library.model.entity.AuthorEntity;
import com.example.Library.model.entity.GenreEntity;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class AddBookDto {

    @NotNull
    private String name;

    @NotNull
    private AuthorEntity author;

    @NotNull
    private GenreEntity genre;


    private long releaseYear;


    private long pages;


    public AddBookDto() {
    }

    public AddBookDto(String name, AuthorEntity author, GenreEntity genre, long releaseYear, long pages) {
        this.name = name;
        this.author = author;
        this.genre = genre;
        this.releaseYear = releaseYear;
        this.pages = pages;
    }

    public String getName() {
        return name;
    }

    public AddBookDto setName(String name) {
        this.name = name;
        return this;
    }

    public AuthorEntity getAuthor() {
        return author;
    }

    public AddBookDto setAuthor(AuthorEntity author) {
        this.author = author;
        return this;
    }

    public GenreEntity getGenre() {
        return genre;
    }

    public AddBookDto setGenre(GenreEntity genre) {
        this.genre = genre;
        return this;
    }

    public long getReleaseYear() {
        return releaseYear;
    }

    public AddBookDto setReleaseYear(long releaseYear) {
        this.releaseYear = releaseYear;
        return this;
    }

    public long getPages() {
        return pages;
    }

    public AddBookDto setPages(long pages) {
        this.pages = pages;
        return this;
    }
}
