package ee.ttu.remonditeenus.model;

import javax.persistence.*;

/**
 * Created by markoka on 9.06.2015.
 */
@Entity
@Table(name = "service_note")
public class ServiceNote {
    private Long serviceNote;
    private Customer customer;
    private Employee employee;
    private String note;
    private ServiceOrder serviceOrder;

    @Id
    @SequenceGenerator(name="snseq", sequenceName="service_note_id", allocationSize=1)
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="snseq")
    @Column(name="service_note")
    public Long getServiceNote() {
        return serviceNote;
    }

    public void setServiceNote(Long serviceNote) {
        this.serviceNote = serviceNote;
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
    @JoinColumn(name = "employee_fk")
    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @Column(name="note")
    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @ManyToOne
    @JoinColumn(name = "service_order_fk")
    public ServiceOrder getServiceOrder() {
        return serviceOrder;
    }

    public void setServiceOrder(ServiceOrder serviceOrder) {
        this.serviceOrder = serviceOrder;
    }
}
