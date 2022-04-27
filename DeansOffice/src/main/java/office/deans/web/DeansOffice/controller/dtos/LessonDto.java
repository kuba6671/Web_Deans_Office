package office.deans.web.DeansOffice.controller.dtos;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class LessonDto {
    private String subjectName;
    private String weekdayName;
    private Double lessonTime;
    private String teacher;
}
