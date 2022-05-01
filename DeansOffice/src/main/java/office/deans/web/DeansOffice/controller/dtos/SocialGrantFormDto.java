package office.deans.web.DeansOffice.controller.dtos;

import lombok.Builder;
import lombok.Getter;

import java.util.Date;

@Getter
@Builder
public class SocialGrantFormDto {
    private Long proposalID;
    private String proposalName;
    private Date proposalDate;
    private Integer academicSession;
    private Integer income;
    private String decision;
    private Long indexNumber;
}
