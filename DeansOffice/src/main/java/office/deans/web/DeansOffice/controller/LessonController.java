package office.deans.web.DeansOffice.controller;

import lombok.RequiredArgsConstructor;
import office.deans.web.DeansOffice.controller.dtos.StudentLessonDto;
import office.deans.web.DeansOffice.controller.dtos.TeacherLessonDto;
import office.deans.web.DeansOffice.controller.mappers.StudentLessonDtoMapper;
import office.deans.web.DeansOffice.controller.mappers.TeacherLessonDtoMapper;
import office.deans.web.DeansOffice.service.LessonService;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class LessonController {

    private final LessonService lessonService;

    private StudentLessonDtoMapper studentLessonDtoMapper;
    private TeacherLessonDtoMapper teacherLessonDtoMapper;

    @GetMapping("/studentLessons")
    public List<StudentLessonDto> getGroupLessons(@RequestParam Long groupID, Sort.Direction sort){
        Sort.Direction sortDirection = sort != null ? sort : Sort.Direction.ASC;
        return studentLessonDtoMapper.mapToStudentLessonDtos(lessonService.getGroupLessons(groupID,sortDirection));
    }

    @GetMapping("/teacherLessons")
    public List<TeacherLessonDto> getTeacherLessons(@RequestParam Long teacherID, Sort.Direction sort){
        Sort.Direction sortDirection = sort != null ? sort : Sort.Direction.ASC;
        return teacherLessonDtoMapper.mapToTeacherLessonDtos(lessonService.getTeacherLessons(teacherID,sortDirection));
    }
}
