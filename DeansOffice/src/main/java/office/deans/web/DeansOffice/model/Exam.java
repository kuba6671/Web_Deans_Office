package office.deans.web.DeansOffice.model;

import lombok.Getter;
import lombok.Setter;
import office.deans.web.DeansOffice.model.persons.Teacher;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
public class Exam {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "EXAM_SEQ")
    @SequenceGenerator(sequenceName = "exam_seq", allocationSize = 1, name = "EXAM_SEQ")
    private Long examID;
    private Date date;
    private String type;
    @ManyToOne
    @JoinColumn(name="groupID")
    private StudentGroup group;

    @ManyToOne
    @JoinColumn(name="teacherID")
    private Teacher teacher;

    @ManyToOne
    @JoinColumn(name="subjectid")
    private Subject subject;
}
