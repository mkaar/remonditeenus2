package ee.ttu.remonditeenus.model;

/**
 * Created by markoka on 9.06.2015.
 */

import javax.persistence.*;

@Entity
@Table(name = "service_request")
public class ServiceRequest {

    private Long serviceRequest;
    private String created;
    private ServiceRequestType serviceRequestStatusType;

    @Id
    @SequenceGenerator(name = "service_request_seq", sequenceName="device_type_id", allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "service_request_seq")
    @Column(name = "service_request")
    public Long getServiceRequest() {
        return serviceRequest;
    }

    public void setServiceRequest(Long serviceRequest) {
        this.serviceRequest = serviceRequest;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    @ManyToOne
    @JoinColumn(name = "service_request_status_type_fk")
    public ServiceRequestType getServiceRequestStatusType() {
        return serviceRequestStatusType;
    }

    public void setServiceRequestStatusType(ServiceRequestType serviceRequestStatusType) {
        this.serviceRequestStatusType = serviceRequestStatusType;
    }
}

