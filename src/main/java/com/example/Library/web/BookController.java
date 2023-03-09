package com.example.Library.web;

import com.example.Library.model.dto.AddBookDto;
import com.example.Library.service.BookService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/")
public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/addbook")
    public String addbook(){
        return "addbook";
    }

    @ModelAttribute("addBookDto")
    public AddBookDto initForm() {
        return new AddBookDto();
    }

    @PostMapping("/addbook")
    public String doAddBook(@Valid AddBookDto addBookDto,
                             BindingResult bindingResult,
                             RedirectAttributes redirectAttributes) {
        System.out.println(addBookDto.toString());

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("addBookDto", addBookDto);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.addBookDto", bindingResult);

            return "redirect:/addbook";
        }

        this.bookService.addBook(addBookDto);

        return "redirect:/allbook";
    }

}
