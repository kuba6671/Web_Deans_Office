package office.deans.web.DeansOffice.service;

import office.deans.web.DeansOffice.model.Mark;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MarkServiceTest {

    @Autowired
    private MarkService markService;

    @Test
    void shouldGetAllStudentMarks(){
        //given
        // when
        List<Mark> markList =  markService.getStudentMarks(1L);
        //then
        assertNotNull(markList);
    }

}