package office.deans.web.DeansOffice.repository;

import office.deans.web.DeansOffice.model.Mark;
import office.deans.web.DeansOffice.model.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectRepository extends JpaRepository<Subject, Long> {
}
