package office.deans.web.DeansOffice.repository;

import office.deans.web.DeansOffice.model.Exam;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExamRepository extends JpaRepository<Exam, Long> {
    List<Exam> findExamByGroup_GroupID(Long groupID, Sort sort);
}
