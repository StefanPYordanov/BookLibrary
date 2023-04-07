package com.example.Library.web;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class RegisterControllerIT {
    @Autowired
    private MockMvc mockMvc;

    @Test
    void testRegistration() throws Exception {
        mockMvc.perform (post("/register")
                        .param ("username", "admin")
                        .param ("email", "admin@examle.com")
                        .param ("password", "test password")
                        .param ("confirmPassword", "test password")
                        .param("fullName", "Test Testov")
                )
                .andExpect (status ()
                        .is3xxRedirection ())
                .andExpect (redirectedUrl ("/login"));
    }

}
