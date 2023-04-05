package com.example.Library.model.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "books")
public class BookEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @ManyToOne (fetch = FetchType.EAGER)
    private AuthorEntity author;

    @ManyToOne (fetch = FetchType.EAGER)
    private GenreEntity genre;

    @Column(nullable = false)
    private long releaseYear;

    @Column(nullable = false)
    private long pages;

    @Column
    private long rating;

    public BookEntity() {
    }

    public BookEntity(String name, AuthorEntity author, GenreEntity genre, long releaseYear, long pages) {
    }

    public Long getId() {
        return id;
    }

    public BookEntity setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public BookEntity setName(String name) {
        this.name = name;
        return this;
    }

    public AuthorEntity getAuthor() {
        return author;
    }

    public BookEntity setAuthor(AuthorEntity author) {
        this.author = author;
        return this;
    }

    public GenreEntity getGenre() {
        return genre;
    }

    public BookEntity setGenre(GenreEntity genre) {
        this.genre = genre;
        return this;
    }

    public long getReleaseYear() {
        return releaseYear;
    }

    public BookEntity setReleaseYear(long releaseYear) {
        this.releaseYear = releaseYear;
        return this;
    }

    public long getPages() {
        return pages;
    }

    public BookEntity setPages(long pages) {
        this.pages = pages;
        return this;
    }

    public long getRating() {
        return rating;
    }

    public BookEntity setRating(long rating) {
        this.rating = rating;
        return this;
    }
}
