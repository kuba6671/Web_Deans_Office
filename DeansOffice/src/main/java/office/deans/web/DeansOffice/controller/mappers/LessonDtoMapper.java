package office.deans.web.DeansOffice.controller.mappers;

import office.deans.web.DeansOffice.controller.dtos.LessonDto;
import office.deans.web.DeansOffice.model.Lesson;
import office.deans.web.DeansOffice.model.Subject;
import office.deans.web.DeansOffice.model.Weekday;
import office.deans.web.DeansOffice.model.persons.Teacher;

import java.util.List;
import java.util.stream.Collectors;

public class LessonDtoMapper {
    private LessonDtoMapper(){}

    public static List<LessonDto> mapToLessonDtos(List<Lesson> lessons){
            return lessons.stream()
                    .map(lesson -> mapToLessonDto(lesson, lesson.getSubject(), lesson.getTeacher(), lesson.getWeekday()))
                    .collect(Collectors.toList());
    }

    private static LessonDto mapToLessonDto(Lesson lesson, Subject subject, Teacher teacher, Weekday weekday){
        String teacherFullName = teacher.getName() + " " + teacher.getSurname();
        return LessonDto.builder()
                .subjectName(subject.getName())
                .weekdayName(weekday.getName())
                .lessonTime(lesson.getLessonTime())
                .teacher(teacherFullName)
                .build();
    }
}
