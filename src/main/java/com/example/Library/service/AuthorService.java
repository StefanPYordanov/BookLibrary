package com.example.Library.service;


import com.example.Library.model.dto.AddAuthorDto;
import com.example.Library.model.entity.AuthorEntity;
import com.example.Library.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {
    private final AuthorRepository authorRepository;

    @Autowired
    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public List<AuthorEntity> getAllAuthors() {
        return authorRepository.findAll();
    }

    public void addAuthor(AddAuthorDto addAuthorDto) {

        AuthorEntity author = new AuthorEntity()
                .setName(addAuthorDto.getName())
                .setYearOfBirth(addAuthorDto.getYearOfBirth())
                .setNationality(addAuthorDto.getNationality());


        this.authorRepository.save(author);
    }

    public List<AddAuthorDto> getAuthors() {
        return
                authorRepository.
                        findAll().
                        stream().
                        map(this::map).
                        toList();
    }

    private AddAuthorDto map(AuthorEntity authorEntity) {
        return new AddAuthorDto()
                .setName(authorEntity.getName())
                .setYearOfBirth(authorEntity.getYearOfBirth())
                .setNationality(authorEntity.getNationality());

    }

}


