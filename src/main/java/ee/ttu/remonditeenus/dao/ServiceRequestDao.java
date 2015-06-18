package ee.ttu.remonditeenus.dao;

import ee.ttu.remonditeenus.model.*;

import java.util.List;

/**
 * Created by markoka on 9.06.2015.
 */
public interface ServiceRequestDao {


    List<ServiceRequest> getAllServiceRequestsByCustomerId(Long customerId);

    List<ServiceRequest> getAllServiceRequests();

    ServiceRequest getServiceRequestById(Integer id);

    List<ServiceNote> getNotesByServiceRequestId(Integer id);

    void putNote(ServiceNote note);

    void createServiceRequest(ServiceRequest serviceRequest);

    ServiceRequestType getType(Long i);

    List<ServiceRequestStatusType> getAllServiceRequestStatusTypes();

    void updateServiceRequest(ServiceRequest sr);

    void createServiceOrder(ServiceOrder serviceOrder);

    ServiceOrderStatusType getSoStatusType(int i);

    List<ServiceRequest> getAllServiceRequestsByCustomerName(String client);

    List<ServiceRequest> getAllServiceRequestsByOrderId(String orderId);

    List<ServiceOrder> getServicesByEmployee(String employee);

    List<ServiceRequest> getServicesByStatus(String status);
}
