package com.example.Library.service;

import com.example.Library.model.dto.RegistrationDto;
import com.example.Library.model.entity.UserEntity;
import com.example.Library.repository.UserRepository;
import com.example.Library.repository.UserRoleRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
@ExtendWith(MockitoExtension.class)
public class RegisterServiceTest {
    private RegisterService toTest;
    @Mock
    private UserRepository mockUserRepository;
    @Mock
    private PasswordEncoder mockPasswordEncoder;
    @Mock
    private UserRoleRepository mockUserRoleRepository;
    @Captor
    private ArgumentCaptor<UserEntity> userEntityCaptor;
    @BeforeEach
    void setUp() {
        toTest = new RegisterService(
                mockUserRepository,
                mockPasswordEncoder,
                mockUserRoleRepository
                );
    }
    @Test
    void testUserRegister(){
        RegistrationDto testRegistrationDto = new RegistrationDto()
                .setUsername("test")
                .setPassword("password")
                .setEmail("test@example.com")
                .setRepeatPassword("password")
                .setFullName("Test Testov");
        when(mockPasswordEncoder.encode(testRegistrationDto.getPassword())).thenReturn("encoded password");
        toTest.register(testRegistrationDto);
        verify(mockUserRepository).save(userEntityCaptor.capture());
        UserEntity savedUser = userEntityCaptor.getValue();
        Assertions.assertEquals(testRegistrationDto.getUsername(), savedUser.getUsername());
        Assertions.assertEquals("encoded password", savedUser.getPassword());
    }
    @Test()
    void testUsernameNotFound(){
        Assertions.assertThrows(UsernameNotFoundException.class,
                () -> toTest.getUser("user_not_exist"));
    }
}
