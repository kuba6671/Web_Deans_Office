package office.deans.web.DeansOffice.model.persons;

import lombok.Getter;
import lombok.Setter;
import office.deans.web.DeansOffice.model.StudentGroup;

import javax.persistence.*;


@Getter
@Setter
@Entity
public class Student extends Person {
    @Id
    private Long indexNumber;
    private String fieldOfStudy;
    @ManyToOne
    @JoinColumn(name="groupID")
    private StudentGroup group;
}
