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

    @Size(min = 0)
    private long releaseYear;

    @Size(min = 0)
    private long pages;
}
