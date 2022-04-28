package office.deans.web.DeansOffice.repository;


import office.deans.web.DeansOffice.model.StudentGroup;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentGroupRepository extends JpaRepository<StudentGroup, Long> {
}
