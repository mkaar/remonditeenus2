package ee.ttu.remonditeenus.model;

/**
 * Created by markoka on 9.06.2015.
 */

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "service_request")
public class ServiceRequest {

    private Long serviceRequest;
    private Customer customer;
    private Employee createdBy;
    private Date created;
    private String serviceDescByCustomer;
    private String serviceDescByEmployee;
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

    @Column(name = "created")
    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
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

    @Column(name = "service_desc_by_customer")
    public String getServiceDescByCustomer() {
        return serviceDescByCustomer;
    }

    public void setServiceDescByCustomer(String serviceDescByCustomer) {
        this.serviceDescByCustomer = serviceDescByCustomer;
    }

    @Column(name = "service_desc_by_employee")
    public String getServiceDescByEmployee() {
        return serviceDescByEmployee;
    }

    public void setServiceDescByEmployee(String serviceDescByEmployee) {
        this.serviceDescByEmployee = serviceDescByEmployee;
    }

    @ManyToOne
    @JoinColumn(name = "customer_fk")
    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @ManyToOne
    @JoinColumn(name = "created_by")
    public Employee getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Employee createdBy) {
        this.createdBy = createdBy;
    }
}

