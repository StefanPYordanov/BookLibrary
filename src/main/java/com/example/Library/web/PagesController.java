package com.example.Library.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class PagesController {

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping ("/spotlight")
    public String spotlight(){
        return "spotlight";
    }

    @GetMapping ("/profile")
    public String profile(){
        return "profile";
    }

    @GetMapping ("/allbooks")
    public String allbooks(){
        return "allbooks";
    }

    @GetMapping ("/about")
    public String about(){
        return "about";
    }

    @GetMapping ("/addbook")
    public String addbook(){
        return "addbook";
    }


}
