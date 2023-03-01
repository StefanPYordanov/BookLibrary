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

    @ManyToOne
    private AuthorEntity author;

    @ManyToOne
    private GenreEntity genre;

    @Column(nullable = false)
    private long releaseYear;

    @Column(nullable = false)
    private long pages;

    public BookEntity() {
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
}
