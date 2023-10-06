package ie.chrischen.irelandstatistics.controller.permit;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

@SpringBootTest
@AutoConfigureMockMvc
public class PermitsCompanyControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @Tag("Unit")
    @Tag("Permit")
    public void testGetPermitsCompanyByYear() throws Exception {
        mockMvc.perform(get("/api/v1/employment-permit/company/2023")
                        .param("page", "0")
                        .param("pageSize", "10")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    @Tag("Unit")
    @Tag("Permit")
    public void testGetPermitsCompanyByEmployer() throws Exception {
        mockMvc.perform(get("/api/v1/employment-permit/company/2023/Deloitte")
                        .param("page", "0")
                        .param("pageSize", "10")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }
}