package office.deans.web.DeansOffice.controller.mappers;

import office.deans.web.DeansOffice.controller.dtos.MarkDto;
import office.deans.web.DeansOffice.model.Mark;
import office.deans.web.DeansOffice.model.Subject;

import java.util.List;
import java.util.stream.Collectors;


public class MarkDtoMapper {
    private MarkDtoMapper(){}
    public static List<MarkDto> mapToMarkDtos(List<Mark> marks){
        return marks.stream()
                .map(mark -> mapToMarkDto(mark, mark.getSubject()))
                .collect(Collectors.toList());
    }

    private static MarkDto mapToMarkDto(Mark mark, Subject subject){
        return MarkDto.builder()
                .name(subject.getName())
                .value(mark.getValue())
                .build();
    }
}
