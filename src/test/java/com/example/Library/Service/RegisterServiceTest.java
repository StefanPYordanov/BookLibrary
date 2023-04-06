package com.example.Library.Service;

import com.example.Library.model.dto.RegistrationDto;
import com.example.Library.model.entity.UserEntity;
import com.example.Library.model.entity.UserRoleEntity;
import com.example.Library.model.enums.RoleTypeEnum;
import com.example.Library.repository.UserRepository;
import com.example.Library.repository.UserRoleRepository;
import com.example.Library.service.ApplicationUserDetailsService;
import com.example.Library.service.RegisterService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

import static org.hibernate.validator.internal.util.Contracts.assertTrue;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class RegisterServiceTest {
    @Mock
    private RegisterService toTest;
    @Mock
    private UserRepository mockUserRepository;
    @Mock
    private PasswordEncoder mockPasswordEncoder;
    @Captor
    private ArgumentCaptor<UserEntity> userEntityCaptor;

    @BeforeEach
    void setUp() {
        toTest = new RegisterService(
                mockUserRepository,
                mockPasswordEncoder
        );
    }


    @Test
    void userRegistrationTest() {
        UserRoleEntity testRole = new UserRoleEntity ();
        testRole.setRole (RoleTypeEnum.ADMIN);

        RegistrationDto testRegistrationDTO = new RegistrationDto ()
                .setUsername ("admin")
                .setFullName("Admin Adminov")
                .setEmail ("admin@example.com")
                .setPassword ("admin12345")
                .setRepeatPassword("admin12345");

        UserEntity testUser = new  UserEntity()
                .setUsername ("admin")
                .setRoles (List.of(testRole))
                .setEmail ("admin@example.com")
                .setFullName ("Admin Adminov")
                .setPassword ("admin12345");

/*        when (mockPasswordEncoder.encode (testRegistrationDTO.getPassword ()))
                .thenReturn (ENCODED_PASSWORD);
        when (mockModelMapper.map (testRegistrationDTO, UserEntity.class)).thenReturn (testUser);
        when (mockUserRoleRepository.findUserRoleByRole (RoleTypeEnum.ADMIN)).thenReturn (List.of (testRole));*/
        toTest.register(testRegistrationDTO);

        Mockito.verify (mockUserRepository).save (userEntityCaptor.capture());
        Assertions.assertEquals ("Admin Adminov", testUser.getFullName());
        Assertions.assertEquals ("admin12345", testUser.getPassword ());
        Assertions.assertEquals (1, testUser.getRoles ().size ());
    }
}
