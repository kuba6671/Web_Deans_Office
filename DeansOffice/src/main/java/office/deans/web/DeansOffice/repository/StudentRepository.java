package office.deans.web.DeansOffice.repository;


import office.deans.web.DeansOffice.model.users.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> getStudentByGroup_GroupID(Long groupID);
    Student getStudentByMail(String mail);

}
