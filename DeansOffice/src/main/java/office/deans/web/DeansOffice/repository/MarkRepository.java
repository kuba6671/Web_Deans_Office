package office.deans.web.DeansOffice.repository;

import office.deans.web.DeansOffice.model.Mark;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MarkRepository extends JpaRepository<Mark, Long> {
    public List<Mark> findMarkByIndexNumber(Long indexNumber);
}
