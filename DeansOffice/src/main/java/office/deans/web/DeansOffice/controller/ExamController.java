package office.deans.web.DeansOffice.controller;

import lombok.RequiredArgsConstructor;
import office.deans.web.DeansOffice.controller.dtos.ExamDto;
import office.deans.web.DeansOffice.controller.mappers.ExamDtoMapper;
import office.deans.web.DeansOffice.model.Exam;
import office.deans.web.DeansOffice.service.ExamService;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
public class ExamController {

    private final ExamService examService;

    private ExamDtoMapper examDtoMapper;

    @GetMapping("/exams/{groupID}")
    public List<ExamDto> getExams(@PathVariable Long groupID, Sort.Direction sort){
        Sort.Direction sortDirection = sort != null ? sort : Sort.Direction.ASC;
        return examDtoMapper.mapToExamDtos(examService.getStudentExams(groupID,sortDirection));
    }

    @PostMapping("/exams")
    public Exam addExam(@RequestBody Exam exam){
        return examService.addExam(exam);
    }
}
