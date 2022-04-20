package office.deans.web.DeansOffice.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Setter
@Entity
public class StudentGroup {
    @Id
    private Long groupID;
    private String name;
}
