package office.deans.web.DeansOffice.repository;

import office.deans.web.DeansOffice.model.Lesson;
import office.deans.web.DeansOffice.model.Timetable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LessonRepository extends JpaRepository<Lesson, Long> {
    List<Lesson> findLessonByTimetable_Group_GroupID(Long groupID, Sort sort);
    List<Lesson> findLessonByTeacher_TeacherID(Long teacherID, Sort sort);
}
