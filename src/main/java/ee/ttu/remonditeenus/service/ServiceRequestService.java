package ee.ttu.remonditeenus.service;

/**
 * Created by markoka on 9.06.2015.
 */
import javax.transaction.Transactional;

import ee.ttu.remonditeenus.dao.ServiceRequestDao;
import ee.ttu.remonditeenus.model.ServiceNote;
import ee.ttu.remonditeenus.model.ServiceRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class ServiceRequestService {

    @Autowired
    private ServiceRequestDao dao;

    public List<ServiceRequest> loadServiceRequests(Long customerId) {
        return dao.getAllServiceRequestsByCustomerId(customerId);
    }

    public ServiceRequest getServiceRequest(Integer id) {
        return dao.getServiceRequestById(id);
    }

    public List<ServiceNote> getNotes(Integer id) {
        return dao.getNotesByServiceRequestId(id);
    }
}