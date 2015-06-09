package ee.ttu.remonditeenus.dao;

import ee.ttu.remonditeenus.model.ServiceNote;
import ee.ttu.remonditeenus.model.ServiceRequest;

import java.util.List;

/**
 * Created by markoka on 9.06.2015.
 */
public interface ServiceRequestDao {


    List<ServiceRequest> getAllServiceRequestsByCustomerId(Long customerId);

    ServiceRequest getServiceRequestById(Integer id);

    List<ServiceNote> getNotesByServiceRequestId(Integer id);
}
