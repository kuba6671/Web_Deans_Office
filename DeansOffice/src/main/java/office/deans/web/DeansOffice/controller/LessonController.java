package office.deans.web.DeansOffice.controller;

import lombok.RequiredArgsConstructor;
import office.deans.web.DeansOffice.controller.dtos.StudentLessonDto;
import office.deans.web.DeansOffice.controller.dtos.TeacherLessonDto;
import office.deans.web.DeansOffice.controller.mappers.StudentLessonDtoMapper;
import office.deans.web.DeansOffice.controller.mappers.TeacherLessonDtoMapper;
import office.deans.web.DeansOffice.model.Lesson;
import office.deans.web.DeansOffice.service.LessonService;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
public class LessonController {

    private final LessonService lessonService;

    private StudentLessonDtoMapper studentLessonDtoMapper;
    private TeacherLessonDtoMapper teacherLessonDtoMapper;

    @GetMapping("/studentLessons/{groupID}")
    public List<StudentLessonDto> getGroupLessons(@PathVariable Long groupID, Sort.Direction sort){
        Sort.Direction sortDirection = sort != null ? sort : Sort.Direction.ASC;
        return studentLessonDtoMapper.mapToStudentLessonDtos(lessonService.getGroupLessons(groupID,sortDirection));
    }

    @GetMapping("/teacherLessons/{teacherID}")
    public List<TeacherLessonDto> getTeacherLessons(@PathVariable Long teacherID, Sort.Direction sort){
        Sort.Direction sortDirection = sort != null ? sort : Sort.Direction.ASC;
        return teacherLessonDtoMapper.mapToTeacherLessonDtos(lessonService.getTeacherLessons(teacherID,sortDirection));
    }

    @PostMapping("/lessons")
    public Lesson addLesson(@RequestBody Lesson lesson){
        return lessonService.addLesson(lesson);
    }
}
