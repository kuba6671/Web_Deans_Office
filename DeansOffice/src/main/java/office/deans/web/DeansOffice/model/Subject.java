package office.deans.web.DeansOffice.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SUBJECT_SEQ")
    @SequenceGenerator(sequenceName = "subject_seq", allocationSize = 1, name = "SUBJECT_SEQ")
    private Long subjectID;
    String name;
}
