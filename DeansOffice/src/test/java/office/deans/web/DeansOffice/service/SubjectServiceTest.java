package office.deans.web.DeansOffice.service;

import office.deans.web.DeansOffice.model.Subject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class SubjectServiceTest {

    @Autowired
    private SubjectService subjectService;

    @Test
    void shouldGetAllSubjects(){
        //given
        // when
        List<Subject> subjectList = subjectService.getSubjects();
        //then
        assertNotNull(subjectList);
        assertEquals(subjectList.size(),2);
    }

}