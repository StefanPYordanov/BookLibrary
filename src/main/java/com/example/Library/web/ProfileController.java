package com.example.Library.web;

import com.example.Library.model.dto.UserProfileDto;
import com.example.Library.model.entity.UserEntity;
import com.example.Library.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
@RequestMapping("/")
public class ProfileController {

    private final UserService userService;

    public ProfileController(UserService userService) {
        this.userService = userService;
    }

    //TODO Fix profile page (didn't work)

    @GetMapping("/profile")
    public String profile(Principal principal, Model model){
        String username = principal.getName();
        UserEntity userEntity = userService.getUser(username);

        UserProfileDto userProfileDto = new UserProfileDto()
                .setUsername(username)
                .setEmail(userEntity.getEmail())
                .setFullName(userEntity.getFullName());


        model.addAttribute("user", userProfileDto);

        return "profile";
    }

}
