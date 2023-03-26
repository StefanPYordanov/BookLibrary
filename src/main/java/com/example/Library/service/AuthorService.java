package com.example.Library.service;


import com.example.Library.model.dto.AddAuthorDto;
import com.example.Library.model.dto.AddBookDto;
import com.example.Library.model.entity.AuthorEntity;
import com.example.Library.model.entity.BookEntity;
import com.example.Library.model.entity.UserEntity;
import com.example.Library.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {
    private final AuthorRepository authorRepository;

    @Autowired
    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public List<AuthorEntity> getAllAuthors () {
        return authorRepository.findAll();
    }

    public void addAuthor(AddAuthorDto addAuthorDto) {

        AuthorEntity author = new AuthorEntity(
                addAuthorDto.getName(),
                addAuthorDto.getYearOfBirth(),
                addAuthorDto.getNationality()
        );

        this.authorRepository.save(author);
    }

}
