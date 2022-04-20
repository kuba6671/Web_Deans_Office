package office.deans.web.DeansOffice.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Setter
@Entity
public class Lesson {
    @Id
    private Long lessonID;
    private Double lessonTime;
    private Long timetableID;
    private Long weekdayID;
    private Long subjectID;
    private Long teacherID;
}
