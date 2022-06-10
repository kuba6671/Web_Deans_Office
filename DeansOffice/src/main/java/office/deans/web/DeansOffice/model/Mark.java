package office.deans.web.DeansOffice.model;

import lombok.Getter;
import lombok.Setter;
import office.deans.web.DeansOffice.model.users.Student;
import office.deans.web.DeansOffice.model.users.Teacher;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import java.math.BigDecimal;

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

    @ManyToOne
    @JoinColumn(name="subjectid")
    private Subject subject;

    @ManyToOne
    @JoinColumn(name="teacherID")
    private Teacher teacher;
    @Range(min =2, max = 5)
    private BigDecimal value;
}
