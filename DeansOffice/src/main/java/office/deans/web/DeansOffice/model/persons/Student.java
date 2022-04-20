package office.deans.web.DeansOffice.model.persons;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Setter
@Entity
public class Student extends Person {
    @Id
    private Long indexNumber;
    private Long groupID;
    private String fieldOfStudy;
}
