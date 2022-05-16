package office.deans.web.DeansOffice.controller;

import lombok.RequiredArgsConstructor;
import office.deans.web.DeansOffice.controller.dtos.MarkDto;
import office.deans.web.DeansOffice.controller.mappers.MarkDtoMapper;
import office.deans.web.DeansOffice.model.Mark;
import office.deans.web.DeansOffice.service.MarkService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MarkController {
    private final MarkService markService;

    private MarkDtoMapper markDtoMapper;

    @GetMapping("/marks/{indexNumber}")
    public List<MarkDto> getMarks(@PathVariable Long indexNumber){
        return markDtoMapper.mapToMarkDtos(markService.getStudentMarks(indexNumber));
    }

    @PostMapping("/marks")
    public Mark addMark(@RequestBody Mark mark){
        return markService.addMark(mark);
    }
}
