package com.example.Library.web;

import com.example.Library.model.dto.AddBookDto;
import com.example.Library.model.dto.BookViewDto;
import com.example.Library.model.entity.GenreEntity;
import com.example.Library.repository.GenreRepository;
import com.example.Library.service.BookService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/")
public class BookController {

    private final BookService bookService;
    private final GenreRepository genreRepository;

    @Autowired
    public BookController(BookService bookService, GenreRepository genreRepository) {
        this.bookService = bookService;
        this.genreRepository = genreRepository;
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

    @GetMapping ("/allbooks")
    public String allbooks(Model model){
        List<BookViewDto> books = bookService.getAllBooks();

        model.addAttribute("books", books);
        return "allbooks";
    }

    @GetMapping("/details/{id}")
    public String getRoute(@PathVariable("id") Long bookId, Model model) {
        BookViewDto book = bookService.getBook(bookId);

        model.addAttribute("book", book);

        return "book-details";
    }

}