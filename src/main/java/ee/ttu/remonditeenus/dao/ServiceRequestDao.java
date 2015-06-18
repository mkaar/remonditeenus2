package ee.ttu.remonditeenus.dao;

import ee.ttu.remonditeenus.model.ServiceNote;
import ee.ttu.remonditeenus.model.ServiceRequest;
import ee.ttu.remonditeenus.model.ServiceRequestStatusType;
import ee.ttu.remonditeenus.model.ServiceRequestType;

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
}
