package office.deans.web.DeansOffice.model.persons;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Setter
@Entity
public class Teacher extends Person{
    @Id
    private Long teacherID;
}
