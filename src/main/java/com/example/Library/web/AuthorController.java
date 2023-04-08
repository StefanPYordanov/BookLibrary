package com.example.Library.web;

import com.example.Library.model.dto.AddAuthorDto;
import com.example.Library.repository.AuthorRepository;
import com.example.Library.service.AuthorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
@Controller
@RequestMapping("/")
public class AuthorController {
    private final AuthorService authorService;
    private final AuthorRepository authorRepository;
    @Autowired
    public AuthorController(AuthorService authorService, AuthorRepository authorRepository) {
        this.authorService = authorService;
        this.authorRepository = authorRepository;
    }
    @GetMapping("/addauthor")
    public String addauthor(){
        return "addauthor";
    }
    @ModelAttribute("addAuthorDto")
    public AddAuthorDto initForm() {
        return new AddAuthorDto();
    }
    @PostMapping("/addauthor")
    public String doAddAuthor(@Valid AddAuthorDto addAuthorDto,
                            BindingResult bindingResult,
                            RedirectAttributes redirectAttributes) {
        System.out.println(addAuthorDto.toString());
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("addAuthorDto", addAuthorDto);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.addAuthorDto", bindingResult);
            return "redirect:/addauthor";
        }
        this.authorService.addAuthor(addAuthorDto);
        return "redirect:/allauthor";
    }
    @GetMapping ("/allauthors")
    public String getAllAuthors(Model model) {
        var allAuthors = authorService.getAuthors();
        model.addAttribute("authors", allAuthors);
        return "allauthors";
    }
}
