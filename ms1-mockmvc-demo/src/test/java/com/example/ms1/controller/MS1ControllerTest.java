package com.example.ms1.controller;

import com.example.ms1.model.User;
import com.example.ms1.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(MS1Controller.class)
public class MS1ControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private UserService userService;

    @Test
    void testAddEndpoint() throws Exception {
        mockMvc.perform(get("/ms1/add")
                        .param("a", "5")
                        .param("b", "10"))
                .andExpect(status().isOk())
                .andExpect(content().string("MS 1.1 - Additon = 15"));
    }

    @Test
    void testGetAllUsersEndpoint() throws Exception {
        when(userService.getAllUsers()).thenReturn(List.of(
                new User(1L, "Alice", "alice@example.com")
        ));

        mockMvc.perform(get("/ms1/users"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").value("Alice"));
    }
}
