package com.example.Library.model.entity;

import com.example.Library.model.enums.GenreTypeEnum;
import jakarta.persistence.*;

@Entity
@Table(name = "genres")
public class GenreEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private GenreTypeEnum genreName;

    @Column(columnDefinition = "TEXT")
    private String description;

    public GenreEntity() {
    }

    public Long getId() {
        return id;
    }

    public GenreEntity setId(Long id) {
        this.id = id;
        return this;
    }

    public GenreTypeEnum getGenreName() {
        return genreName;
    }

    public GenreEntity setGenreName(GenreTypeEnum genreName) {
        this.genreName = genreName;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public GenreEntity setDescription(String description) {
        this.description = description;
        return this;
    }
}
