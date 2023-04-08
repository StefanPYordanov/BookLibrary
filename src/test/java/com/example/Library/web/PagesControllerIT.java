package com.example.Library.web;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
@SpringBootTest
@AutoConfigureMockMvc
public class PagesControllerIT {
    @Autowired
    private MockMvc mockMvc;
    @Test
    void testGetHomePage() throws Exception {
        mockMvc.perform(get("/"))
                .andExpect(status().is2xxSuccessful());
    }
    @Test
    void testGetSpotlightPage() throws Exception {
        mockMvc.perform(get("/spotlight"))
                .andExpect(status().is2xxSuccessful());
    }
    @Test
    void testGetAboutPage() throws Exception {
        mockMvc.perform(get("/about"))
                .andExpect(status().is2xxSuccessful());
    }
}
