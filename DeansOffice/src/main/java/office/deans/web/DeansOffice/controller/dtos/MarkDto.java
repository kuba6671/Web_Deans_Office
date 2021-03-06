package office.deans.web.DeansOffice.controller.dtos;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.Range;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import java.math.BigDecimal;

@Getter
@Builder
@RequiredArgsConstructor
public class MarkDto {
    private String name;
    private BigDecimal value;

    public MarkDto(String name, BigDecimal value) {
        this.name = name;
        if(value.doubleValue() <2.0 || value.doubleValue() >5.0)
            throw new IllegalArgumentException("Mark value must be from 2.0-5.0 range");
        this.value = value;
    }
}
