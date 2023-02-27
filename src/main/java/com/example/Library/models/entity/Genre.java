package com.example.Library.models.entity;

import com.example.Library.models.enums.GenreType;
import jakarta.persistence.*;

@Entity
@Table(name = "genres")
public class Genre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private GenreType genreName;

    @Column(columnDefinition = "TEXT")
    private String description;

    public Genre() {
    }

    public Long getId() {
        return id;
    }

    public Genre setId(Long id) {
        this.id = id;
        return this;
    }

    public GenreType getGenreName() {
        return genreName;
    }

    public Genre setGenreName(GenreType genreName) {
        this.genreName = genreName;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Genre setDescription(String description) {
        this.description = description;
        return this;
    }
}
