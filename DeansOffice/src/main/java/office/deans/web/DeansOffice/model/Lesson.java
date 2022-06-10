package office.deans.web.DeansOffice.model;

import lombok.Getter;
import lombok.Setter;
import office.deans.web.DeansOffice.model.users.Teacher;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class Lesson {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "LESSON_SEQ")
    @SequenceGenerator(sequenceName = "lesson_seq", allocationSize = 1, name = "LESSON_SEQ")
    private Long lessonID;
    private Double lessonTime;
    @ManyToOne
    @JoinColumn(name="timetableID")
    private Timetable timetable;

    @ManyToOne
    @JoinColumn(name="weekdayID")
    private Weekday weekday;

    @ManyToOne
    @JoinColumn(name="subjectid")
    private Subject subject;

    @ManyToOne
    @JoinColumn(name="teacherID")
    private Teacher teacher;
}
