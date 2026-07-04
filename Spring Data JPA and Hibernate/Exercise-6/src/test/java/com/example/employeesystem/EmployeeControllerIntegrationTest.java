package com.example.employeesystem;

import static org.hamcrest.Matchers.containsString;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class EmployeeControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void paginationAndSortingEndpointsShouldReturnExpectedResults() throws Exception {
        mockMvc.perform(get("/employees/page").param("page", "0").param("size", "3"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("\"name\":\"John\"")));

        mockMvc.perform(get("/employees/sort").param("field", "name"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Alice")));

        mockMvc.perform(get("/employees/pageSort").param("page", "0").param("size", "3").param("field", "name"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Alice")));
    }
}
