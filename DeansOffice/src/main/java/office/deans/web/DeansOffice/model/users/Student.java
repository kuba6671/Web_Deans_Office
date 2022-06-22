package office.deans.web.DeansOffice.model.users;

import lombok.Getter;
import lombok.Setter;
import office.deans.web.DeansOffice.model.StudentGroup;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;


@Getter
@Setter
@Entity
public class Student extends User {
    @Id
    private Long indexNumber;
    private String fieldOfStudy;
    @ManyToOne
    @JoinColumn(name="groupID")
    private StudentGroup group;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_STUDENT"));
        return authorities;
    }
}
