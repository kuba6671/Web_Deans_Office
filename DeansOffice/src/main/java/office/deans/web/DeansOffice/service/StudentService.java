package office.deans.web.DeansOffice.service;

import lombok.RequiredArgsConstructor;
import office.deans.web.DeansOffice.model.users.Student;
import office.deans.web.DeansOffice.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;

    public List<Student> getStudents(){
        return studentRepository.findAll();
    }

    public List<Student> getStudentByGroup(Long groupID){
        return studentRepository.getStudentByGroup_GroupID(groupID);
    }

    public Student addStudent(Student student){
        return studentRepository.save(student);
    }
}
