package office.deans.web.DeansOffice.service;


import lombok.RequiredArgsConstructor;
import office.deans.web.DeansOffice.model.StudentGroup;
import office.deans.web.DeansOffice.repository.StudentGroupRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentGroupService {
    private final StudentGroupRepository studentGroupRepository;

    public List<StudentGroup> getStudentGroups(){
        return studentGroupRepository.findAll();
    }

    public StudentGroup addStudentGroup(StudentGroup studentGroup){
        return studentGroupRepository.save(studentGroup);
    }

}
