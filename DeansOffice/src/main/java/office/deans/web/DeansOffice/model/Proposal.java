package office.deans.web.DeansOffice.model;

import lombok.Getter;
import lombok.Setter;
import office.deans.web.DeansOffice.model.persons.Student;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
public class Proposal {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PROPOSAL_SEQ")
    @SequenceGenerator(sequenceName = "proposal_seq", allocationSize = 1, name = "PROPOSAL_SEQ")
    private Long proposalID;
    private String proposalName;
    private Date date;
    private Integer session;
    private Integer income;
    private double avg;
    private String decision;
    @ManyToOne
    @JoinColumn(name="indexNumber")
    private Student student;
}
