package com.example.Library.web;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
@SpringBootTest
@AutoConfigureMockMvc
public class BookControllerIT {
    @Autowired
    private MockMvc mockMvc;
    @Test
    void testAddingBook() throws Exception {
        mockMvc.perform(post("/addbook")
                .param("name", "test book")
                .param("author", "test author")
                .param("genre", "Fantasy")
                .param("releaseYear", "1965")
                .param("pages", "500")
                .with(csrf()))
                .andExpect(status().is3xxRedirection());
    }
    @Test
    void testAddingBookFailed() throws Exception {
        mockMvc.perform(post("/addbook")
                .param("name", "1L")
                .param("author", "test author")
                .param("genre", "Fantasy")
                .param("releaseYear", "1965")
                .param("pages", "500")
                .with(csrf()))
                .andExpect(status().is3xxRedirection())
                .andExpect (redirectedUrl ("/addbook"));
    }
    @Test
    void testDeleteBook() throws Exception {
        mockMvc.perform(delete("/details/1")
                .param("id", "1")
                .param("name", "1L")
                .param("author", "test author")
                .param("genre", "Fantasy")
                .param("releaseYear", "1965")
                .param("pages", "500")
                .with(csrf()))
                .andExpect(status().is3xxRedirection())
                .andExpect (redirectedUrl ("/allbooks"));
    }
    @Test
    void testGetAllBooksPage() throws Exception {
        mockMvc.perform(get("/allbooks"))
                .andExpect(status().is2xxSuccessful());
    }
    @Test
    @WithMockUser(username = "test")
    void testGetAddBooksPage() throws Exception {
        mockMvc.perform(get("/addbook"))
                .andExpect(status().is2xxSuccessful());
    }
    @Test
    void testGetBooksDetailsPage() throws Exception {
        mockMvc.perform(get("/details/1")
                .param("id", "1")
                .param("name", "1L")
                .param("author", "test author")
                .param("genre", "Fantasy")
                .param("releaseYear", "1965")
                .param("pages", "500")
                .with(csrf()))
                .andExpect(status().is2xxSuccessful());
    }
}