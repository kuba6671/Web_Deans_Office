package office.deans.web.DeansOffice.service;

import lombok.RequiredArgsConstructor;
import office.deans.web.DeansOffice.model.Lesson;
import office.deans.web.DeansOffice.model.Timetable;
import office.deans.web.DeansOffice.repository.LessonRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LessonService {

    private final LessonRepository lessonRepository;

    public List<Lesson> getGroupLessons(Long groupID, Sort.Direction sort){
        return lessonRepository.findLessonByTimetable_Group_GroupID(groupID, Sort.by(sort, "weekday","lessonTime"));
    }

    public List<Lesson> getTeacherLessons(Long teacherID, Sort.Direction sort){
        return lessonRepository.findLessonByTeacher_TeacherID(teacherID, Sort.by(sort, "weekday","lessonTime"));
    }

    public Lesson addLesson(Lesson lesson){
        return lessonRepository.save(lesson);
    }
}
