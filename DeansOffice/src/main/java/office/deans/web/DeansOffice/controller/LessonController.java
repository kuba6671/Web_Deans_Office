package office.deans.web.DeansOffice.controller;

import lombok.RequiredArgsConstructor;
import office.deans.web.DeansOffice.controller.dtos.LessonDto;
import office.deans.web.DeansOffice.controller.mappers.LessonDtoMapper;
import office.deans.web.DeansOffice.model.Lesson;
import office.deans.web.DeansOffice.model.Timetable;
import office.deans.web.DeansOffice.service.LessonService;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class LessonController {

    private final LessonService lessonService;

    private LessonDtoMapper lessonDtoMapper;

    @GetMapping("/lessons")
    public List<LessonDto> getGroupLessons(@RequestParam Long groupID, Sort.Direction sort){
        Sort.Direction sortDirection = sort != null ? sort : Sort.Direction.ASC;
        return lessonDtoMapper.mapToLessonDtos(lessonService.getGroupLessons(groupID,sortDirection));
    }
}
