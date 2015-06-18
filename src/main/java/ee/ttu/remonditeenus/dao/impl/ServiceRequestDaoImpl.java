package ee.ttu.remonditeenus.dao.impl;

/**
 * Created by markoka on 9.06.2015.
 */
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ee.ttu.remonditeenus.dao.ServiceRequestDao;
import ee.ttu.remonditeenus.model.*;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public class ServiceRequestDaoImpl implements ServiceRequestDao {

    @PersistenceContext
    EntityManager em;

    @Override
    public List<ServiceRequest> getAllServiceRequestsByCustomerId(Long customerId) {
        List<ServiceRequest> requests;
        Query q = em.createQuery("from ServiceRequest where customer_fk = :customerId").setParameter("customerId", customerId);
        requests = (List<ServiceRequest>) q.getResultList();
        return requests;
    }

    @Override
    public List<ServiceRequest> getAllServiceRequests() {
        List<ServiceRequest> requests;
        Query q = em.createQuery("from ServiceRequest");
        requests = (List<ServiceRequest>) q.getResultList();
        return requests;
    }

    @Override
    public ServiceRequest getServiceRequestById(Integer id) {
        return (ServiceRequest) em.createQuery("from ServiceRequest where service_request = :id").setParameter("id", id).getSingleResult();
    }

    @Override
    public List<ServiceNote> getNotesByServiceRequestId(Integer id) {
        List<ServiceNote> notes;
        ServiceOrder so = (ServiceOrder) em.createQuery("from ServiceOrder where service_request_fk = :id").setParameter("id", id).getSingleResult();
        Query q = em.createQuery("from ServiceNote where service_order_fk= :id").setParameter("id", so.getServiceOrder());
        notes = (List<ServiceNote>) q.getResultList();
        return notes;
    }

    @Override
    public void putNote(ServiceNote note) {
        em.persist(note);
    }

    @Override
    public void createServiceRequest(ServiceRequest serviceRequest) {
        em.persist(serviceRequest);
    }

    @Override
    public ServiceRequestType getType(Long i) {
        return (ServiceRequestType)em.createQuery("from ServiceRequestType where service_request_status_type = :id").setParameter("id", i).getSingleResult();
    }

    @Override
    public List<ServiceRequestStatusType> getAllServiceRequestStatusTypes() {
        return (List<ServiceRequestStatusType>)em.createQuery("from ServiceRequestStatusType").getResultList();
    }

    @Override
    public void updateServiceRequest(ServiceRequest sr) {
        em.merge(sr);
    }

}
