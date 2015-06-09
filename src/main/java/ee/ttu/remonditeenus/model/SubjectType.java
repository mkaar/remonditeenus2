package ee.ttu.remonditeenus.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by markoka on 9.06.2015.
 */
@Entity
@Table(name = "subject_type")
public class SubjectType {
    private Long subject_type;
    private String name;

    @Id
    @Column(name="subject_type")
    public Long getSubject_type() {
        return subject_type;
    }

    public void setSubject_type(Long subject_type) {
        this.subject_type = subject_type;
    }

    @Column(name="type_name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
