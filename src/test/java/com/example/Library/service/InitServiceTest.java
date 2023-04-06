package com.example.Library.service;

import com.example.Library.model.entity.UserEntity;
import com.example.Library.repository.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;

@ExtendWith(MockitoExtension.class)
public class InitServiceTest {
    public InitService toTest;
    @Mock
    private UserRoleRepository mockUserRoleRepository;
    @Mock
    private UserRepository mockUserRepository;
    @Mock
    private AuthorRepository mockAuthorRepository;
    @Mock
    private GenreRepository mockGenreRepository;
    @Mock
    private BookRepository mockBookRepository;
    @Mock
    private PasswordEncoder mockPasswordEncoder;

    @BeforeEach
    void setUp() {
        toTest = new InitService (mockUserRoleRepository,
                mockUserRepository,
                mockAuthorRepository,
                mockGenreRepository,
                mockBookRepository,
                mockPasswordEncoder
        );
    }

    @Test
    void testInitializeRoles(){

    }
}
