package com.example.Library.service;

import com.example.Library.model.entity.UserEntity;
import com.example.Library.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import static org.mockito.Mockito.*;
@ExtendWith(MockitoExtension.class)
public class UserServiceTest {
    private UserService toTest;
    @Mock
    private UserRepository mockUserRepository;
    @BeforeEach
    void setUp() {
        toTest = new UserService (mockUserRepository);
    }
    @Test
    void testGetUserByUsername(){
        UserEntity testUser = new UserEntity()
                .setId(1L)
                .setUsername("test")
                .setPassword("password")
                .setEmail("test@example.com")
                .setFullName("Test Testov");
        when(mockUserRepository.findUserEntityByUsername("test")).thenReturn(Optional.of(testUser));
        UserEntity userEntity = toTest.getUser("test");
        Assertions.assertEquals("test", userEntity.getUsername());
    }
    @Test
    void testGetUserById(){
        UserEntity testUser = new UserEntity()
                .setId(1L)
                .setUsername("test")
                .setPassword("password")
                .setEmail("test@example.com")
                .setFullName("Test Testov");
        when(mockUserRepository.findUserEntityById(1L)).thenReturn(Optional.of(testUser));
        UserEntity userEntity = toTest.getUserById(1L);
        Assertions.assertEquals(1L, userEntity.getId());
    }
    @Test
    void testGetAllUsers(){
        UserEntity testUser = new UserEntity()
                .setId(1L)
                .setUsername("test")
                .setPassword("password")
                .setEmail("test@example.com")
                .setFullName("Test Testov");
        UserEntity testUser2 = new UserEntity()
                .setId(2L)
                .setUsername("test2")
                .setPassword("password2")
                .setEmail("tes@example.com")
                .setFullName("Tests Testovs");
        List<UserEntity> listOfUsers = new ArrayList<>();
        listOfUsers.add(testUser);
        listOfUsers.add(testUser2);
        when(mockUserRepository.findAll()).thenReturn(listOfUsers);
        List<UserEntity> listOfAllUserReturnedByRepository = toTest.getUsers();
        Assertions.assertEquals(2, listOfAllUserReturnedByRepository.size());
    }
}
