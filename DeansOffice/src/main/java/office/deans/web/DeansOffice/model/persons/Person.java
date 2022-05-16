package office.deans.web.DeansOffice.model.persons;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Getter
@Setter
@MappedSuperclass
public class Person {
    private String name;
    private String surname;
    @Min(1)
    @Max(99)
    private int age;
    private String phoneNumber;
    @Email
    private String mail;
    private String password;
}
