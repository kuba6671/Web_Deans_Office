package office.deans.web.DeansOffice.controller;


import lombok.RequiredArgsConstructor;
import office.deans.web.DeansOffice.model.StudentGroup;
import office.deans.web.DeansOffice.service.StudentGroupService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class StudentGroupController {
    private final StudentGroupService studentGroupService;

    @GetMapping("/studentGroups")
    public List<StudentGroup> getStudentGroups(){
        return studentGroupService.getStudentGroups();
    }

    @PostMapping("/studentGroups")
    public StudentGroup addStudentGroup(@RequestBody StudentGroup studentGroup){
        return studentGroupService.addStudentGroup(studentGroup);
    }
}
