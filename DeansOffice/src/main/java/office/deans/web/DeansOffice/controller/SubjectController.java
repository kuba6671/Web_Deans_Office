package office.deans.web.DeansOffice.controller;

import lombok.RequiredArgsConstructor;
import office.deans.web.DeansOffice.model.Subject;
import office.deans.web.DeansOffice.service.SubjectService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
public class SubjectController {

    private final SubjectService subjectService;

    @GetMapping("/subjects")
    public List<Subject> getSubjects(){
        return subjectService.getSubjects();
    }

    @PostMapping("/subjects")
    public Subject addSubject(@Valid @RequestBody Subject subject){
        return subjectService.addSubject(subject);
    }
}
