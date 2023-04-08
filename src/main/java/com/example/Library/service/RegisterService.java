package com.example.Library.service;

import com.example.Library.model.dto.RegistrationDto;
import com.example.Library.model.entity.UserEntity;
import com.example.Library.model.enums.RoleTypeEnum;
import com.example.Library.repository.UserRepository;
import com.example.Library.repository.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.Optional;
@Service
public class RegisterService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserRoleRepository userRoleRepository;
    @Autowired
    public RegisterService(UserRepository userRepository, PasswordEncoder passwordEncoder, UserRoleRepository userRoleRepository ) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.userRoleRepository = userRoleRepository;
    }
    public void register(RegistrationDto registrationDTO) {
        if (!registrationDTO.getPassword().equals(registrationDTO.getRepeatPassword())) {
            throw new RuntimeException("passwords don't match");
        }
        Optional<UserEntity> byEmail = this.userRepository.findByEmail(registrationDTO.getEmail());
        if (byEmail.isPresent()) {
            throw new RuntimeException("email.used");
        }
        Optional<UserEntity> byUsername = this.userRepository.findUserEntityByUsername(registrationDTO.getUsername());
        if (byUsername.isPresent()) {
            throw new RuntimeException("username.used");
        }
        UserEntity user = new UserEntity().
                setUsername(registrationDTO.getUsername()).
                setEmail(registrationDTO.getEmail()).
                setPassword(passwordEncoder.encode(registrationDTO.getPassword())).
                setFullName(registrationDTO.getFullName()).
                setRoles(userRoleRepository.findUserRoleByRole(RoleTypeEnum.USER));
        this.userRepository.save(user);
    }
    public UserEntity getUser(String username) {
        return userRepository.findUserEntityByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException(username + " was not found!"));
    }
}
