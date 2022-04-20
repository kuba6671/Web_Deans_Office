package office.deans.web.DeansOffice.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class Timetable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TIMETABLE_SEQ")
    @SequenceGenerator(sequenceName = "timetable_seq", allocationSize = 1, name = "TIMETABLE_SEQ")
    private Long timetableID;

    @ManyToOne
    @JoinColumn(name="groupID")
    private StudentGroup group;
}
