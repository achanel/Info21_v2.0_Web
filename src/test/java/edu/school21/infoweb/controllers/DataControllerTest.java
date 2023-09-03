package edu.school21.infoweb.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.school21.infoweb.models.Tasks;
import edu.school21.infoweb.services.TablesService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(controllers = DataController.class)
class DataControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private TablesService tablesService;
    Tasks task1 = new Tasks("newTask", null, 999999);
    Tasks task2 = new Tasks("updateTask", null, 111111);

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getTable() throws Exception {
        mockMvc.perform(get("/v1/data/get_table"))
                .andDo(print())
                .andExpectAll(
                        status().isOk(),
                        content().contentType(MediaType.APPLICATION_JSON)
//                        jsonPath("$.peersList").isNotEmpty()
                );
    }

    @Test
    void saveNewTable() throws Exception {
        mockMvc.perform(post("/v1/data/save_table")
                        .content(asJsonString(task1))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpectAll(
                        status().isCreated()
//                        MockMvcResultMatchers.content()
                );
//        System.out.println("====" + mockMvc.toString() + "====");
    }

    @Test
    void deleteTable() throws Exception {
        mockMvc.perform(get("/v1/data/delete_table")
                        .contentType("application/json"))
                .andExpectAll(
                        status().isOk()
//                        jsonPath("$.peersList").doesNotExist()
                );
    }

    @Test
    void updateTable() throws Exception {
        mockMvc.perform(get("/v1/data/update_table")
                        .content(asJsonString(task2))
                        .contentType("application/json"))
                .andExpectAll(
                        status().isOk()
//                        jsonPath("$.peersList").exists()
                );
    }

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}