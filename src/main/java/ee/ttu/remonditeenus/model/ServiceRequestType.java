package ee.ttu.remonditeenus.model;

import javax.persistence.*;

/**
 * Created by markoka on 9.06.2015.
 */
@Entity
@Table(name = "service_request_status_type")
public class ServiceRequestType {
    private Long serviceRequesStatusType;
    private String name;

    @Id
    @SequenceGenerator(name="sRStatusTypeSeq", sequenceName="service_request_status_type_id", allocationSize=1)
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="sRStatusTypeSeq")
    @Column(name = "service_request_status_type")
    public Long getServiceRequesStatusType() {
        return serviceRequesStatusType;
    }

    public void setServiceRequesStatusType(Long serviceRequesStatusType) {
        this.serviceRequesStatusType = serviceRequesStatusType;
    }

    @Column(name = "type_name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
