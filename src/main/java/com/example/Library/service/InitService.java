package com.example.Library.service;

import com.example.Library.model.entity.AuthorEntity;
import com.example.Library.model.entity.BookEntity;
import com.example.Library.model.entity.UserEntity;
import com.example.Library.model.entity.UserRoleEntity;
import com.example.Library.model.enums.RoleTypeEnum;
import com.example.Library.repository.AuthorRepository;
import com.example.Library.repository.GenreRepository;
import com.example.Library.repository.UserRepository;
import com.example.Library.repository.UserRoleRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InitService {
    private final UserRoleRepository userRoleRepository;
    private final UserRepository userRepository;

    private final AuthorRepository authorRepository;
    private final GenreRepository genreRepository;

    @Autowired
    public InitService(UserRoleRepository userRoleRepository, UserRepository userRepository, AuthorRepository authorRepository,
                       GenreRepository genreRepository) {
        this.userRoleRepository = userRoleRepository;
        this.userRepository = userRepository;
        this.authorRepository = authorRepository;
        this.genreRepository = genreRepository;
    }

    @PostConstruct
    public void init() {
        initRoles();
        initUsers();

    }

    private void initRoles() {
        if (userRoleRepository.count() == 0) {
            var admin = new UserRoleEntity().setRole(RoleTypeEnum.ADMIN);
            var moderator = new UserRoleEntity().setRole(RoleTypeEnum.MODERATOR);

            userRoleRepository.save(admin);
            userRoleRepository.save(moderator);

        }
    }


    private void initUsers() {
        if (userRepository.count() == 0) {
            initAdmin();
            initModerator();
            initUser();
        }
    }

    private void initAdmin() {
        var adminRole = userRoleRepository.
                findUserRoleByRole(RoleTypeEnum.ADMIN).orElseThrow();


        var admin = new UserEntity()
                .setUsername("admin")
                .setPassword("admin12345")
                .setEmail("admin@example.com")
                .setFullName("Admin Adminov")
                .setRole(adminRole);


        userRepository.save(admin);
    }

    private void initModerator() {
        var moderatorRole = userRoleRepository.
                findUserRoleByRole(RoleTypeEnum.MODERATOR).orElseThrow();


        var moderator = new UserEntity()
                .setUsername("moderator")
                .setPassword("moderator12345")
                .setEmail("moderator@example.com")
                .setFullName("Moderator Moderatov")
                .setRole(moderatorRole);

        userRepository.save(moderator);
    }

    private void initUser() {
        var user = new UserEntity()
                .setUsername("user")
                .setPassword("user12345")
                .setEmail("user@example.com")
                .setFullName("User Userov");

        userRepository.save(user);
    }

    private void initAuthor(){
        var author = new AuthorEntity()
                .setName("J. K. Rowling")
                .setNationality("British")
                .setYearOfBirth(1965);

        var author2 = new AuthorEntity()
                .setName("J. R. R. Tolkien")
                .setNationality("British")
                .setYearOfBirth(1892);

        var author3 = new AuthorEntity()
                .setName("Samuel Bjork")
                .setNationality("Norway")
                .setYearOfBirth(1969);

        authorRepository.save(author);
        authorRepository.save(author2);
        authorRepository.save(author3);
    }

/*    private void initBook(){
        var genre = genreRepository.
                findUserRoleByRole(GenreTypeEnum.Fantasy).orElseThrow();

        var book = new BookEntity()
                .setName("Harry Potter and the Philosopher stone")
                .setAuthor()
                .setGenre()
                .setReleaseYear()
                .setPages();

                //TODO: init 3 books in database !!!
    }*/
}