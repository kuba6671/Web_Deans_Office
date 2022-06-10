package office.deans.web.DeansOffice.controller.mappers;

import office.deans.web.DeansOffice.controller.dtos.StudentLessonDto;
import office.deans.web.DeansOffice.model.Lesson;
import office.deans.web.DeansOffice.model.Subject;
import office.deans.web.DeansOffice.model.Weekday;
import office.deans.web.DeansOffice.model.users.Teacher;

import java.util.List;
import java.util.stream.Collectors;

public class StudentLessonDtoMapper {
    private StudentLessonDtoMapper(){}

    public static List<StudentLessonDto> mapToStudentLessonDtos(List<Lesson> lessons){
            return lessons.stream()
                    .map(lesson -> mapToLessonDto(lesson, lesson.getSubject(), lesson.getTeacher(), lesson.getWeekday()))
                    .collect(Collectors.toList());
    }

    private static StudentLessonDto mapToLessonDto(Lesson lesson, Subject subject, Teacher teacher, Weekday weekday){
        String teacherFullName = teacher.getName() + " " + teacher.getSurname();
        return StudentLessonDto.builder()
                .subjectName(subject.getName())
                .weekdayName(weekday.getName())
                .lessonTime(lesson.getLessonTime())
                .teacher(teacherFullName)
                .build();
    }
}
