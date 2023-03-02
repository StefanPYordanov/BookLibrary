package com.example.Library.service;

import com.example.Library.model.entity.*;
import com.example.Library.model.enums.GenreTypeEnum;
import com.example.Library.model.enums.RoleTypeEnum;
import com.example.Library.repository.*;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InitService {
    private final UserRoleRepository userRoleRepository;
    private final UserRepository userRepository;

    private final AuthorRepository authorRepository;
    private final GenreRepository genreRepository;

    private final BookRepository bookRepository;

    @Autowired
    public InitService(UserRoleRepository userRoleRepository, UserRepository userRepository, AuthorRepository authorRepository,
                       GenreRepository genreRepository, BookRepository bookRepository) {
        this.userRoleRepository = userRoleRepository;
        this.userRepository = userRepository;
        this.authorRepository = authorRepository;
        this.genreRepository = genreRepository;
        this.bookRepository = bookRepository;
    }

    @PostConstruct
    public void init() {
        initRoles();
        initUsers();
        initContent();
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

    private void initContent(){

        var fantasy = new GenreEntity().setGenreName(GenreTypeEnum.Fantasy);
        var thriller = new GenreEntity().setGenreName(GenreTypeEnum.Thriller);
        var drama = new GenreEntity().setGenreName(GenreTypeEnum.Drama);
        var sciFi = new GenreEntity().setGenreName(GenreTypeEnum.SciFi);
        var romance = new GenreEntity().setGenreName(GenreTypeEnum.Romance);
        var fiction = new GenreEntity().setGenreName(GenreTypeEnum.Fiction);

        if (genreRepository.count() == 0){

            genreRepository.save(fantasy);
            genreRepository.save(thriller);
            genreRepository.save(drama);
            genreRepository.save(sciFi);
            genreRepository.save(romance);
            genreRepository.save(fiction);
        }

        if (bookRepository.count() == 0) {

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


                    var book = new BookEntity()
                .setName("Harry Potter and the Philosopher stone")
                .setAuthor(author)
                .setGenre(fantasy)
                .setReleaseYear(1997)
                .setPages(223);


            var book2 = new BookEntity()
                    .setName("The Lord of the Ring")
                    .setAuthor(author2)
                    .setGenre(fantasy)
                    .setReleaseYear(1954)
                    .setPages(1178);

            var book3 = new BookEntity()
                    .setName("I am Travelling Alone")
                    .setAuthor(author3)
                    .setGenre(thriller)
                    .setReleaseYear(2013)
                    .setPages(400);

                bookRepository.save(book);
                bookRepository.save(book2);
                bookRepository.save(book3);

        }

    }


}
