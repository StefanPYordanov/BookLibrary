package com.example.Library.models.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @ManyToOne
    private Author author;

    @ManyToOne
    private Genre genre;

    @Column(nullable = false)
    private long releaseYear;

    @Column(nullable = false)
    private long pages;

    public Book() {
    }

    public Long getId() {
        return id;
    }

    public Book setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Book setName(String name) {
        this.name = name;
        return this;
    }

    public Author getAuthor() {
        return author;
    }

    public Book setAuthor(Author author) {
        this.author = author;
        return this;
    }

    public Genre getGenre() {
        return genre;
    }

    public Book setGenre(Genre genre) {
        this.genre = genre;
        return this;
    }

    public long getReleaseYear() {
        return releaseYear;
    }

    public Book setReleaseYear(long releaseYear) {
        this.releaseYear = releaseYear;
        return this;
    }

    public long getPages() {
        return pages;
    }

    public Book setPages(long pages) {
        this.pages = pages;
        return this;
    }
}
