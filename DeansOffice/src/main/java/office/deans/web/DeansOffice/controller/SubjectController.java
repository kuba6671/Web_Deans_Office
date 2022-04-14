package office.deans.web.DeansOffice.controller;

import lombok.RequiredArgsConstructor;
import office.deans.web.DeansOffice.model.Subject;
import office.deans.web.DeansOffice.service.SubjectService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class SubjectController {

    private final SubjectService subjectService;

    @GetMapping("/subjects")
    public List<Subject> getSubject(){
        return subjectService.getSubjects();
    }

    @PostMapping("/subjects")
    public Subject addSubject(@RequestBody Subject subject){
        return subjectService.addSubject(subject);
    }
}
