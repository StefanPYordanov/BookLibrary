package com.example.Library.web;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
@SpringBootTest
@AutoConfigureMockMvc
public class AdminControllerIT {
    @Autowired
    private MockMvc mockMvc;

    //TODO: admin controller should move business logic to service !
    @Test
    @WithMockUser(username = "test", roles = {"ADMIN"})
    void testDeleteUser() throws Exception {
        mockMvc.perform(delete("/remove-roles/admin/1")).
                andExpect(status().is3xxRedirection())
                .andExpect (redirectedUrl ("/admin"));
    }
}
