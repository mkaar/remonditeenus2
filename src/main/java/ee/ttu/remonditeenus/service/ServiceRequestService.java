package ee.ttu.remonditeenus.service;

/**
 * Created by markoka on 9.06.2015.
 */
import javax.transaction.Transactional;

import ee.ttu.remonditeenus.dao.ServiceRequestDao;
import ee.ttu.remonditeenus.dao.UserDao;
import ee.ttu.remonditeenus.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class ServiceRequestService {

    @Autowired
    private ServiceRequestDao dao;

    @Autowired
    private UserDao userDao;

    public List<ServiceRequest> loadServiceRequests(Long customerId) {
        return dao.getAllServiceRequestsByCustomerId(customerId);
    }

    public ServiceRequest getServiceRequest(Integer id) {
        return dao.getServiceRequestById(id);
    }
    public List<ServiceRequest> getAllServiceRequests() {
        return dao.getAllServiceRequests();
    }

    public List<ServiceNote> getNotes(Integer id) {
        return dao.getNotesByServiceRequestId(id);
    }

    public void putNote(ServiceNote note){
        dao.putNote(note);
    }

    public Customer findCustomerById(Long customerId) {
        //TODO: Add functionality
        return null;
    }

    public ServiceRequestType getServiceRequestStatusType(Long i) {
        return dao.getType(i);
    }

    public List<ServiceRequestStatusType> getAllServiceStatusTypes() {
        return dao.getAllServiceRequestStatusTypes();
    }

    public void updateServiceRequest(ServiceRequest sr, Integer status) {
        sr.setServiceRequestStatusType(getServiceRequestStatusType(new Long(status)));
        dao.updateServiceRequest(sr);
    }

    public void updateServiceRequestClient(ServiceRequest sr, Integer customer) {
        sr.setCustomer(userDao.getCustomerById(new Long(customer)));
        dao.updateServiceRequest(sr);
    }
}