package office.deans.web.DeansOffice.repository;

import office.deans.web.DeansOffice.model.Mark;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MarkRepository extends JpaRepository<Mark, Long> {
   List<Mark> findMarkByStudent_IndexNumber(Long indexNumber);
}
