package ee.ttu.remonditeenus.model;

/**
 * Created by markoka on 18.06.2015.
 */
public class ServiceRequestForm {

    private Long person;
    private String serviceDescByCustomer;
    private String serviceDescByEmployee;
    private String employeeUsername;

    public Long getPerson() {
        return person;
    }

    public void setPerson(Long person) {
        this.person = person;
    }

    public String getServiceDescByCustomer() {
        return serviceDescByCustomer;
    }

    public void setServiceDescByCustomer(String serviceDescByCustomer) {
        this.serviceDescByCustomer = serviceDescByCustomer;
    }

    public String getServiceDescByEmployee() {
        return serviceDescByEmployee;
    }

    public void setServiceDescByEmployee(String serviceDescByEmployee) {
        this.serviceDescByEmployee = serviceDescByEmployee;
    }

    public String getEmployeeUsername() {
        return employeeUsername;
    }

    public void setEmployeeUsername(String employeeUsername) {
        this.employeeUsername = employeeUsername;
    }
}
