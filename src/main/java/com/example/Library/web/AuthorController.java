package com.example.Library.web;

import com.example.Library.model.dto.AddAuthorDto;
import com.example.Library.service.AuthorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/")
public class AuthorController {

    private final AuthorService authorService;

    @Autowired
    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
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

        return "redirect:/allauthors";

    }

    @GetMapping ("/allauthors")
    public String getAllAuthors(Model model) {

        var allAuthors = authorService.getAuthors();

        model.addAttribute("authors", allAuthors);

        return "allauthors";
    }



}
