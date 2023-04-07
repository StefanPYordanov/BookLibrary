package com.example.Library.service;

import com.example.Library.model.entity.*;
import com.example.Library.model.enums.GenreTypeEnum;
import com.example.Library.model.enums.RoleTypeEnum;
import com.example.Library.repository.*;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class InitService {
    private final UserRoleRepository userRoleRepository;
    private final UserRepository userRepository;

    private final AuthorRepository authorRepository;
    private final GenreRepository genreRepository;

    private final BookRepository bookRepository;

    private final PasswordEncoder passwordEncoder;

    @Autowired
    public InitService(UserRoleRepository userRoleRepository, UserRepository userRepository, AuthorRepository authorRepository,
                       GenreRepository genreRepository, BookRepository bookRepository, PasswordEncoder passwordEncoder) {
        this.userRoleRepository = userRoleRepository;
        this.userRepository = userRepository;
        this.authorRepository = authorRepository;
        this.genreRepository = genreRepository;
        this.bookRepository = bookRepository;
        this.passwordEncoder = passwordEncoder;
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
            var user = new UserRoleEntity().setRole(RoleTypeEnum.USER);

            userRoleRepository.save(admin);
            userRoleRepository.save(user);

        }
    }


    private void initUsers() {
        if (userRepository.count() == 0) {
            initAdmin();
           /* initModerator();*/
            initUser();
        }
    }

    private void initAdmin() {

        var admin = new UserEntity()
                .setUsername("admin")
                .setPassword(passwordEncoder.encode("admin12345"))
                .setEmail("admin@example.com")
                .setFullName("Admin Adminov")
                .setRoles(userRoleRepository.findAll());


        userRepository.save(admin);
    }

/*    private void initModerator() {

        var moderator = new UserEntity()
                .setUsername("moderator")
                .setPassword(passwordEncoder.encode("moderator12345"))
                .setEmail("moderator@example.com")
                .setFullName("Moderator Moderatov")
                .setRoles(userRoleRepository.findUserRoleByRole(RoleTypeEnum.MODERATOR));

        userRepository.save(moderator);
    }*/

    private void initUser() {
        var user = new UserEntity()
                .setUsername("user")
                .setPassword(passwordEncoder.encode("user12345"))
                .setEmail("user@example.com")
                .setFullName("User Userov")
                .setRoles(userRoleRepository.findUserRoleByRole(RoleTypeEnum.USER));


        userRepository.save(user);
    }

    private void initContent(){

        var fantasy = new GenreEntity()
                .setGenreName(GenreTypeEnum.Fantasy)
                .setDescription("Fantasy fiction is a genre of writing in which" +
                        " the plot could not happen in real life (as we know it, at least). " +
                        "Often, the plot involves magic or witchcraft and takes place" +
                        " on another planet or in another — undiscovered — dimension of this world.");
        var thriller = new GenreEntity()
                .setGenreName(GenreTypeEnum.Thriller)
                .setDescription("Thriller is a genre of fiction with numerous, " +
                        "often overlapping, subgenres, including crime, horror and detective fiction.");
        var drama = new GenreEntity()
                .setGenreName(GenreTypeEnum.Drama)
                .setDescription("A drama is a type of narrative writing that is meant to be performed in front of an audience.");
        var sciFi = new GenreEntity()
                .setGenreName(GenreTypeEnum.SciFi)
                .setDescription("Science fiction, also often known as 'sci-fi'," +
                        " is a genre of literature that is imaginative and based around science.");
        var romance = new GenreEntity()
                .setGenreName(GenreTypeEnum.Romance)
                .setDescription("The romance genre is defined by two aspects" +
                        " that can be found in every romance book or novel: a central love story between" +
                        " characters. an emotionally satisfying, happy ending.");
        var fiction = new GenreEntity()
                .setGenreName(GenreTypeEnum.Fiction)
                .setDescription("Genre fiction, also known as popular fiction," +
                        " is a term used in the book-trade for fictional works written with the intent of fitting into a " +
                        "specific literary genre, in order to appeal to readers and fans already familiar with that genre.");

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

