package com.example.Library.model.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "authors")
public class AuthorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column
    private long yearOfBirth;

    @Column(nullable = false)
    private String nationality;

    public AuthorEntity() {
    }

    public AuthorEntity(String name, long yearOfBirth, String nationality) {
    }

    public Long getId() {
        return id;
    }

    public AuthorEntity setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public AuthorEntity setName(String name) {
        this.name = name;
        return this;
    }

    public long getYearOfBirth() {
        return yearOfBirth;
    }

    public AuthorEntity setYearOfBirth(long yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
        return this;
    }

    public String getNationality() {
        return nationality;
    }

    public AuthorEntity setNationality(String nationality) {
        this.nationality = nationality;
        return this;
    }
}
