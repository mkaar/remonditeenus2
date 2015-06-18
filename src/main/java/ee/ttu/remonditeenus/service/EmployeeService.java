package ee.ttu.remonditeenus.service;

import ee.ttu.remonditeenus.model.Customer;
import ee.ttu.remonditeenus.model.ServiceOrder;
import ee.ttu.remonditeenus.model.ServiceRequest;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by markoka on 18.06.2015.
 */


public interface EmployeeService {
    List<Customer> getAllCustomers();

    void createServiceRequest(ServiceRequest serviceRequest);

    void createServiceOrder(ServiceOrder serviceOrder);

    List<ServiceRequest> getServiceRequestByClientName(String client);
}
