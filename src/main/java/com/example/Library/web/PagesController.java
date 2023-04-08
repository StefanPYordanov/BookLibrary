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
    @GetMapping ("/about")
    public String about(){
        return "about";
    }
}
