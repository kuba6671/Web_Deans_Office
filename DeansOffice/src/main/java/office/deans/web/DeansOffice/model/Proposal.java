package office.deans.web.DeansOffice.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Getter
@Setter
@Entity
public class Proposal {
    @Id
    private Long proposalID;
    private String proposalName;
    private Date date;
    private Integer session;
    private Integer income;
    private double avg;
    private String decision;
    private Long indexNumber;
}
