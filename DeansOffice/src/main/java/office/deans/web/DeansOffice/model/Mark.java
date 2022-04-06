package office.deans.web.DeansOffice.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Setter
@Entity
public class Mark {
    @Id
    private Long markID;
    private Long indexNumber;
    private Long subjectID;
    private Long teacherID;
    private Long value;


}
