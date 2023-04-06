package com.example.Library.Service;

import com.example.Library.model.entity.UserEntity;
import com.example.Library.model.entity.UserRoleEntity;
import com.example.Library.model.enums.RoleTypeEnum;
import com.example.Library.repository.UserRepository;
import com.example.Library.service.ApplicationUserDetailsService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ApplicationUserDetailsServiceTest {

    private final String NOT_EXISTING_USERNAME = "not exist";
    private final String EXISTING_USERNAME = "admin";
    private final String PASSWORD = "admin12345";

    private ApplicationUserDetailsService toTest;

    @Mock
    private UserRepository mockUserRepository;

    @BeforeEach
    void setUp() {
        toTest = new ApplicationUserDetailsService(
                mockUserRepository
        );
    }

    @Test
    void userFoundTest() {


        UserRoleEntity testAdminRole = new UserRoleEntity().setRole(RoleTypeEnum.ADMIN);
        UserRoleEntity testModeratorRole = new UserRoleEntity().setRole(RoleTypeEnum.MODERATOR);


        UserEntity testUserEntity = new UserEntity().
                setUsername(EXISTING_USERNAME).
                setPassword(PASSWORD).
                setRoles(List.of(testAdminRole, testModeratorRole));


        when(mockUserRepository.findUserEntityByUsername(EXISTING_USERNAME)).
                thenReturn(Optional.of(testUserEntity));

        UserDetails adminDetails =
                toTest.loadUserByUsername(EXISTING_USERNAME);

        Assertions.assertNotNull(adminDetails);
        Assertions.assertEquals(EXISTING_USERNAME, adminDetails.getUsername());
        Assertions.assertEquals(testUserEntity.getPassword(), adminDetails.getPassword());

        Assertions.assertEquals(2,
                adminDetails.getAuthorities().size());
    }

    @Test
    void testUserNotFound() {
       Assertions.assertThrows(
                UsernameNotFoundException.class,
                () -> toTest.loadUserByUsername(NOT_EXISTING_USERNAME)
        );
    }
}
