package office.deans.web.DeansOffice.model.users;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Setter
@Entity
public class Teacher extends User {
    @Id
    private Long teacherID;
}
