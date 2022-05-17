package office.deans.web.DeansOffice.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import office.deans.web.DeansOffice.model.Subject;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import static org.junit.jupiter.api.Assertions.*;

@AutoConfigureMockMvc
@SpringBootTest
class SubjectControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void shouldGetAllSubjects() throws Exception {
        //when
        MvcResult mvcResult = mockMvc.perform(get("/subjects"))
                .andDo(print())
                .andExpect(status().is(200))
                .andReturn();
        //then
        List<Subject> subjects = objectMapper.readValue
                (mvcResult.getResponse().getContentAsString(), new TypeReference<List<Subject>>() {
                });

        assertNotNull(subjects);
        assertEquals(subjects.get(0).getSubjectID(), 100);
        assertEquals(subjects.get(1).getSubjectID(), 200);
        assertEquals(subjects.get(0).getName(), "testName");
        assertEquals(subjects.get(1).getName(), "testName");
    }

    @Test
    void statusShouldBe400WhenNameIsEmpty() throws Exception {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", "");
        MvcResult mvcResult = mockMvc.perform(post("/subjects")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonObject.toString())
                )
                .andDo(print())
                .andExpect(status().is(400))
                .andReturn();
    }

    @Test
    void statusShouldBe400WhenNameIsNull() throws Exception {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", null);
        MvcResult mvcResult = mockMvc.perform(post("/subjects")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonObject.toString())
                )
                .andDo(print())
                .andExpect(status().is(400))
                .andReturn();
    }

}