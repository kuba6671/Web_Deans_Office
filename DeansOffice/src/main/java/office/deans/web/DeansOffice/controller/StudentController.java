package office.deans.web.DeansOffice.controller;

import lombok.RequiredArgsConstructor;
import office.deans.web.DeansOffice.model.users.Student;
import office.deans.web.DeansOffice.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
public class StudentController {
    private final StudentService studentService;

    @GetMapping("/students")
    public List<Student> getStudents(){
        return studentService.getStudents();
    }

    @GetMapping("/students/{groupID}")
    public List<Student> getStudentsByGroup(@PathVariable Long groupID){
        return studentService.getStudentByGroup(groupID);
    }

    @RequestMapping(method = RequestMethod.POST, path = "/students")
    public Student addStudent(@RequestBody Student student){
        return studentService.addStudent(student);
    }
}
