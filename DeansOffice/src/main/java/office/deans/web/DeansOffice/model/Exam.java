package office.deans.web.DeansOffice.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Getter
@Setter
@Entity
public class Exam {
    @Id
    private Long examID;
    private Date date;
    private String type;
    private Long groupID;
    private Long teacherID;
    private Long subjectID;
}
