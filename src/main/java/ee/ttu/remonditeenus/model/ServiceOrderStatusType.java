package ee.ttu.remonditeenus.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by markoka on 9.06.2015.
 */
@Entity
@Table(name="so_status_type")
public class ServiceOrderStatusType {
    private Long soStatusType;
    private String name;

    @Id
    @Column(name="so_status_type")
    public Long getSoStatusType() {
        return soStatusType;
    }

    public void setSoStatusType(Long soStatusType) {
        this.soStatusType = soStatusType;
    }

    @Column(name="type_name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
