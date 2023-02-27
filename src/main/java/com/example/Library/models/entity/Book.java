package com.example.Library.models.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String name;

    @ManyToOne
    private Genre genre;

    @Column(nullable = false)
    private long releaseYear;

    public Book() {
    }

    public long getId() {
        return id;
    }

    public Book setId(long id) {
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
}
