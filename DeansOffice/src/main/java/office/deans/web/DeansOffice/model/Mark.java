package office.deans.web.DeansOffice.model;

import lombok.Getter;
import lombok.Setter;
import office.deans.web.DeansOffice.model.persons.Student;
import office.deans.web.DeansOffice.model.persons.Teacher;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
public class Mark {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "MARK_SEQ")
    @SequenceGenerator(sequenceName = "mark_seq", allocationSize = 1, name = "MARK_SEQ")
    private Long markID;

    @ManyToOne
    @JoinColumn(name="indexNumber")
    private Student student;
    //private Long indexNumber;

    @ManyToOne
    @JoinColumn(name="subjectid")
    private Subject subject;

    @ManyToOne
    @JoinColumn(name="teacherID")
    private Teacher teacher;
    private Double value;
}
