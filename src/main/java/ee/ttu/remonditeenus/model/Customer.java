package ee.ttu.remonditeenus.model;

import javax.persistence.*;

/**
 * Created by markoka on 9.06.2015.
 */
@Entity
@Table(name = "service_note")
public class Customer {
    private Long customer;
    private UserAccount subject;
    private SubjectType subjectType;

    @Id
    @Column(name = "service_request")
    public Long getCustomer() {
        return customer;
    }

    public void setCustomer(Long customer) {
        this.customer = customer;
    }

    @ManyToOne
    @JoinColumn(name = "subject_fk")
    public UserAccount getSubject() {
        return subject;
    }

    public void setSubject(UserAccount subject) {
        this.subject = subject;
    }

    @ManyToOne
    @JoinColumn(name = "subject_type_fk")
    public SubjectType getSubjectType() {
        return subjectType;
    }

    public void setSubjectType(SubjectType subjectType) {
        this.subjectType = subjectType;
    }
}
