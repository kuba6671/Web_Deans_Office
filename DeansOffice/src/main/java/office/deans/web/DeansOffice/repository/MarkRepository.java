package office.deans.web.DeansOffice.repository;

import office.deans.web.DeansOffice.model.Mark;
import office.deans.web.DeansOffice.model.persons.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.Column;
import java.util.List;

@Repository
public interface MarkRepository extends JpaRepository<Mark, Long> {
   List<Mark> findMarkByStudent_IndexNumber(Long indexNumber);
}
