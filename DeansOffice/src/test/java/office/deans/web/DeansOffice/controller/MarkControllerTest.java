package office.deans.web.DeansOffice.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import office.deans.web.DeansOffice.controller.dtos.MarkDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class MarkControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void shouldGetAllStudentMarks() throws Exception {
        //given
        //when
            MvcResult mvcResult= mockMvc.perform(get("/marks/1"))
                .andExpect(status().is(200))
                .andReturn();
        //then
        List<MarkDto> markDtoList = objectMapper.readValue
                (mvcResult.getResponse().getContentAsString(), new TypeReference<List<MarkDto>>() {});

        assertNotNull(markDtoList);
        assertEquals(markDtoList.get(0).getName(),"testName");
        assertEquals(markDtoList.get(0).getValue().doubleValue(),3.0);
        assertEquals(markDtoList.get(1).getValue().doubleValue(),5.0);
    }

    @Test
    void shouldThrownIllegalArgumentExceptionWhenMarkValueIsOutOfRange(){
        IllegalArgumentException exception =
                assertThrows(IllegalArgumentException.class,
                        () -> new MarkDto("testName",new BigDecimal(1.00)));
        assertEquals("Mark value must be from 2.0-5.0 range",exception.getMessage());
    }
}