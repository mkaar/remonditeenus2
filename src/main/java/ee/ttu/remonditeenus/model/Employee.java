package ee.ttu.remonditeenus.model;

import javax.persistence.*;

/**
 * Created by markoka on 9.06.2015.
 */
@Entity
@Table(name="employee")
public class Employee {
    private Long employee;
    private Person person;

    @Id
    @Column(name="employee")
    public Long getEmployee() {
        return employee;
    }

    public void setEmployee(Long employee) {
        this.employee = employee;
    }

    @ManyToOne
    @JoinColumn(name = "person_fk")
    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
