package office.deans.web.DeansOffice.controller.mappers;

import office.deans.web.DeansOffice.controller.dtos.TeacherLessonDto;
import office.deans.web.DeansOffice.model.Lesson;
import office.deans.web.DeansOffice.model.Subject;
import office.deans.web.DeansOffice.model.Timetable;
import office.deans.web.DeansOffice.model.Weekday;

import java.util.List;
import java.util.stream.Collectors;

public class TeacherLessonDtoMapper {
    private TeacherLessonDtoMapper(){}

    public static List<TeacherLessonDto> mapToTeacherLessonDtos(List<Lesson> lessons){
        return lessons.stream()
                .map(lesson -> mapToLessonDto(lesson, lesson.getSubject(), lesson.getWeekday(), lesson.getTimetable()))
                .collect(Collectors.toList());
    }

    private static TeacherLessonDto mapToLessonDto(Lesson lesson, Subject subject, Weekday weekday, Timetable timetable){
        return TeacherLessonDto.builder()
                .subjectName(subject.getName())
                .weekdayName(weekday.getName())
                .lessonTime(lesson.getLessonTime())
                .group(timetable.getGroup().getName())
                .build();
    }
}
