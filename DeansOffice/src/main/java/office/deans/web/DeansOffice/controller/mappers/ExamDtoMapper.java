package office.deans.web.DeansOffice.controller.mappers;

import office.deans.web.DeansOffice.controller.dtos.ExamDto;
import office.deans.web.DeansOffice.model.Exam;
import office.deans.web.DeansOffice.model.Subject;

import java.util.List;
import java.util.stream.Collectors;

public class ExamDtoMapper {
   // public ExamDtoMapper(){}

    public static List<ExamDto> mapToExamDtos(List<Exam> exams){
        return exams.stream()
                .map(exam -> mapToExamDto(exam, exam.getSubject()))
                .collect(Collectors.toList());
    }

    private static ExamDto mapToExamDto(Exam exam, Subject subject){
        return ExamDto.builder()
                .subjectName(subject.getName())
                .examDate(exam.getExamDate())
                .type(exam.getType())
                .build();
    }
}
