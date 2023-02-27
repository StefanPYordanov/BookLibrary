package com.example.Library.models.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "authors")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column
    private long yearOfBirth;

    @Column(nullable = false)
    private String nationality;

    public Author() {
    }

    public Long getId() {
        return id;
    }

    public Author setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Author setName(String name) {
        this.name = name;
        return this;
    }

    public long getYearOfBirth() {
        return yearOfBirth;
    }

    public Author setYearOfBirth(long yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
        return this;
    }

    public String getNationality() {
        return nationality;
    }

    public Author setNationality(String nationality) {
        this.nationality = nationality;
        return this;
    }
}
