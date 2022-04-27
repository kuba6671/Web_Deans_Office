package office.deans.web.DeansOffice.controller.dtos;

import lombok.Builder;
import lombok.Getter;

import java.util.Date;

@Getter
@Builder
public class ExamDto {
    private String subjectName;
    private Date examDate;
    private String type;
}
