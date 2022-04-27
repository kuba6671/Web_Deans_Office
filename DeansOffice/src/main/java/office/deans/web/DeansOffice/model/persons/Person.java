package office.deans.web.DeansOffice.model.persons;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@MappedSuperclass
public class Person {
    private String name;
    private String surname;
    private int age;
    private String phoneNumber;
    private String mail;
    private String password;
}
