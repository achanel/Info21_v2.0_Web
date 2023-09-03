package edu.school21.infoweb.controllers;

import edu.school21.infoweb.exception.BusinessException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(controllers = SQLController.class)
class SQLControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    void main() {
    }

    @Test
    void sqlController() throws Exception {
        mockMvc.perform(post("/v1/sql/"))
                .andDo(print())
                .andExpectAll(
                        status().isOk()
//                        content().contentType(MediaType.APPLICATION_JSON)
//                        jsonPath("$.peersList").isNotEmpty()
                );
    }

    @Test
    void csvExport() throws Exception {
        mockMvc.perform(post("/v1/sql/export"))
                .andDo(print())
                .andExpectAll(
                        status().isOk()
//                        content().contentType(MediaType.APPLICATION_JSON)
//                        jsonPath("$.peersList").isNotEmpty()
                );
    }

    @Test
    void csvImport() throws Exception {
        mockMvc.perform(post("/v1/sql/import"))
                .andDo(print())
                .andExpectAll(
                        status().isOk()
//                        content().contentType(MediaType.APPLICATION_JSON)
//                        jsonPath("$.peersList").isNotEmpty()
                );
    }
}