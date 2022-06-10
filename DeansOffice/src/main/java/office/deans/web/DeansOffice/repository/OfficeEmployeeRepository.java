package office.deans.web.DeansOffice.repository;

import office.deans.web.DeansOffice.model.users.OfficeEmployee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OfficeEmployeeRepository extends JpaRepository<OfficeEmployee, Long> {
    OfficeEmployee getOfficeEmployeeByMail(String mail);
}
