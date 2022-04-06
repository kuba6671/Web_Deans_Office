package office.deans.web.DeansOffice.controller;

import lombok.RequiredArgsConstructor;
import office.deans.web.DeansOffice.model.Mark;
import office.deans.web.DeansOffice.service.MarkService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MarkController {

    private final MarkService markService;

    @GetMapping("/marks")
    public List<Mark> getMarks(@RequestParam Long indexNumber){
        return markService.getStudentMarks(indexNumber);
    }
}
