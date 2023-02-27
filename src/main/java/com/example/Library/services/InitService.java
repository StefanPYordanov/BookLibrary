package com.example.Library.services;

import com.example.Library.models.entity.User;
import com.example.Library.models.entity.UserRole;
import com.example.Library.models.enums.RoleType;
import com.example.Library.repositories.UserRepository;
import com.example.Library.repositories.UserRoleRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InitService {
    private final UserRoleRepository userRoleRepository;
    private final UserRepository userRepository;

    @Autowired
    public InitService(UserRoleRepository userRoleRepository, UserRepository userRepository) {
        this.userRoleRepository = userRoleRepository;
        this.userRepository = userRepository;
    }

    @PostConstruct
    public void init() {
        initRoles();
        initUsers();

    }

    private void initRoles() {
        if (userRoleRepository.count() == 0) {
            var admin = new UserRole().setRole(RoleType.ADMIN);
            var moderator = new UserRole().setRole(RoleType.MODERATOR);

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
                findUserRoleByRole(RoleType.ADMIN).orElseThrow();


        var admin = new User()
                .setUsername("admin")
                .setPassword("admin12345")
                .setEmail("admin@example.com")
                .setFullName("Admin Adminov")
                .setRole(adminRole);


        userRepository.save(admin);
    }

    private void initModerator() {
        var moderatorRole = userRoleRepository.
                findUserRoleByRole(RoleType.MODERATOR).orElseThrow();


        var moderator = new User()
                .setUsername("moderator")
                .setPassword("moderator12345")
                .setEmail("moderator@example.com")
                .setFullName("Moderator Moderatov")
                .setRole(moderatorRole);

        userRepository.save(moderator);
    }

    private void initUser() {
        var user = new User()
                .setUsername("user")
                .setPassword("user12345")
                .setEmail("user@example.com")
                .setFullName("User Userov");

        userRepository.save(user);
    }
}