package com.example.Library.model.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class AddAuthorDto {

    @NotNull
    private String name;

    @NotNull
    private long yearOfBirth;
    @NotNull
    private String nationality;

    public AddAuthorDto() {
    }

    public String getName() {
        return name;
    }

    public AddAuthorDto setName(String name) {
        this.name = name;
        return this;
    }

    public long getYearOfBirth() {
        return yearOfBirth;
    }

    public AddAuthorDto setYearOfBirth(long yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
        return this;
    }

    public String getNationality() {
        return nationality;
    }

    public AddAuthorDto setNationality(String nationality) {
        this.nationality = nationality;
        return this;
    }
}
