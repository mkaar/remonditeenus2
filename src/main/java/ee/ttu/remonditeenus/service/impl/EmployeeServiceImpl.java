package ee.ttu.remonditeenus.service.impl;

import ee.ttu.remonditeenus.dao.ServiceRequestDao;
import ee.ttu.remonditeenus.dao.UserDao;
import ee.ttu.remonditeenus.model.Customer;
import ee.ttu.remonditeenus.model.ServiceRequest;
import ee.ttu.remonditeenus.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by markoka on 18.06.2015.
 */
@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    UserDao userDao;

    @Autowired
    ServiceRequestDao serviceRequestDao;

    @Override
    public List<Customer> getAllCustomers() {
        return userDao.getAllCustomers();
    }

    @Override
    public void createServiceRequest(ServiceRequest serviceRequest) {
        serviceRequestDao.createServiceRequest(serviceRequest);
    }
}
