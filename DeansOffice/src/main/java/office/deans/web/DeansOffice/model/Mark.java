package office.deans.web.DeansOffice.model;

import lombok.Getter;
import lombok.Setter;

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
    private Long indexNumber;
    @ManyToOne
    @JoinColumn(name="subjectid")
    private Subject subject;
    private Long teacherID;
    private Double value;
}
