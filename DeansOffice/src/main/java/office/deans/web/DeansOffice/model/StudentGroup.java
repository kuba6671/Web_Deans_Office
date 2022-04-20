package office.deans.web.DeansOffice.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class StudentGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GROUP_SEQ")
    @SequenceGenerator(sequenceName = "group_seq", allocationSize = 1, name = "GROUP_SEQ")
    private Long groupID;
    private String name;
}
