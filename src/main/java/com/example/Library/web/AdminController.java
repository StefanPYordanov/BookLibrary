package com.example.Library.web;

import com.example.Library.model.dto.BookViewDto;
import com.example.Library.model.dto.UserDto;
import com.example.Library.model.entity.UserEntity;
import com.example.Library.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.stream.Collectors;

@Controller
@RequestMapping("/")
public class AdminController {

    private final UserService userService;

    public AdminController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/admin")
    public String admin(Model model){

        var allUsers = userService.getUsers();

        model.addAttribute("users", allUsers);

        return "admin";
    }


}
