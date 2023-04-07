package com.example.Library.web;

import jakarta.persistence.Column;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class AuthorControllerIT {
    @Autowired
    private MockMvc mockMvc;

    @Test
    void testAddingAuthor() throws Exception {
        mockMvc.perform(post("/addauthor").
                        param("name", "test author").
                        param("yearOfBirth", "1965").
                        param("nationality", "Bulgaria").
                        with(csrf())
                ).
                andExpect(status().is3xxRedirection())
                .andExpect (redirectedUrl ("/allauthors"));
    }

    @Test
    void testAddingAuthorFailed() throws Exception {
        mockMvc.perform(post("/addauthor").
                        param("name", "1L").
                        param("yearOfBirth", "").
                        param("nationality", "").
                        with(csrf())
                ).
                andExpect(status().is3xxRedirection())
                .andExpect (redirectedUrl ("/addauthor"));
    }

}
