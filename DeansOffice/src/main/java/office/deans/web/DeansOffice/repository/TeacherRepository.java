package office.deans.web.DeansOffice.repository;

import office.deans.web.DeansOffice.model.users.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {
    Teacher getTeacherByMail(String mail);
}
