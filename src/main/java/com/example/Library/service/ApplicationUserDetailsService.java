//package com.example.Library.service;
//
//import java.util.List;
//
//import com.example.Library.model.entity.UserEntity;
//import com.example.Library.model.entity.UserRoleEntity;
//import com.example.Library.repository.UserRepository;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//
//public class ApplicationUserDetailsService implements UserDetailsService {
//
//    private final UserRepository userRepository;
//
//    public ApplicationUserDetailsService(UserRepository userRepository) {
//        this.userRepository = userRepository;
//    }
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        return
//                userRepository.
//                        findUserEntityByUser(username).
//                        map(this::map).
//                        orElseThrow(() -> new UsernameNotFoundException("User with name " + username + " not found!"));
//    }
//
//    private UserDetails map(UserEntity userEntity) {
//        return new User(
//                userEntity.getEmail(),
//                userEntity.getPassword(),
//                extractAuthorities(userEntity)
//        );
//    }
//
//    private List<GrantedAuthority> extractAuthorities(UserEntity userEntity) {
//        return userEntity.
//                getRole().
//                stream().
//                map(this::mapRole).
//                toList();
//    }
//
//    private GrantedAuthority mapRole(UserRoleEntity userRoleEntity) {
//        return new SimpleGrantedAuthority("ROLE_" + userRoleEntity.getRole().name());
//    }
//}