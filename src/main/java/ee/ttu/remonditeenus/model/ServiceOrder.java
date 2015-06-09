package ee.ttu.remonditeenus.model;

import javax.persistence.*;

/**
 * Created by markoka on 9.06.2015.
 */
@Entity
@Table(name = "service_order")
public class ServiceOrder {
    private Long serviceOrder;
    private ServiceRequest serviceRequest;
    private ServiceOrderStatusType soStatus;

    @Id
    @Column(name="service_order")
    public Long getServiceOrder() {
        return serviceOrder;
    }

    public void setServiceOrder(Long serviceOrder) {
        this.serviceOrder = serviceOrder;
    }

    @ManyToOne
    @JoinColumn(name = "service_request_fk")
    public ServiceRequest getServiceRequest() {
        return serviceRequest;
    }

    public void setServiceRequest(ServiceRequest serviceRequest) {
        this.serviceRequest = serviceRequest;
    }

    @ManyToOne
    @JoinColumn(name = "so_status_type_fk")
    public ServiceOrderStatusType getSoStatus() {
        return soStatus;
    }

    public void setSoStatus(ServiceOrderStatusType soStatus) {
        this.soStatus = soStatus;
    }
}
