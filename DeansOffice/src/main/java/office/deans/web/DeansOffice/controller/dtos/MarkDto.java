package office.deans.web.DeansOffice.controller.dtos;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class MarkDto {
    private String name;
    private Double value;
}
