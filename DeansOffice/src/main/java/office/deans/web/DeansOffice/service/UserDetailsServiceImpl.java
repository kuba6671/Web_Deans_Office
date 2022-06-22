package office.deans.web.DeansOffice.service;

import lombok.RequiredArgsConstructor;
import office.deans.web.DeansOffice.model.users.OfficeEmployee;
import office.deans.web.DeansOffice.model.users.Student;
import office.deans.web.DeansOffice.model.users.Teacher;
import office.deans.web.DeansOffice.repository.OfficeEmployeeRepository;
import office.deans.web.DeansOffice.repository.StudentRepository;
import office.deans.web.DeansOffice.repository.TeacherRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final StudentRepository studentRepository;
    private final TeacherRepository teacherRepository;
    private final OfficeEmployeeRepository officeEmployeeRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User springUser = null;
        Student studentUser = studentRepository.getStudentByMail(username);
        Teacher teacherUser = teacherRepository.getTeacherByMail(username);
        OfficeEmployee officeEmployeeUser = officeEmployeeRepository.getOfficeEmployeeByMail(username);
        if (studentUser != null) {
            springUser = new User(studentUser.getMail(), studentUser.getPassword(), studentUser.getAuthorities());
        } else if (teacherUser != null) {
            springUser = new User(teacherUser.getMail(), teacherUser.getPassword(), teacherUser.getAuthorities());
        } else if (officeEmployeeUser != null) {
            springUser = new User(officeEmployeeUser.getMail(), officeEmployeeUser.getPassword(), officeEmployeeUser.getAuthorities());
        } else {
            throw new UsernameNotFoundException("User not exist");
        }
        return springUser;
    }
}
