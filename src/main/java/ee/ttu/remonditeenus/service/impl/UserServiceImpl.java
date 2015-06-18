package ee.ttu.remonditeenus.service.impl;

/**
 * Created by markoka on 9.06.2015.
 */
import javax.transaction.Transactional;

import ee.ttu.remonditeenus.model.Customer;
import ee.ttu.remonditeenus.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ee.ttu.remonditeenus.dao.UserDao;
import ee.ttu.remonditeenus.model.UserAccount;
import ee.ttu.remonditeenus.service.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public UserAccount loadUserByUsername(String username) {
        return userDao.loadUserByUsername(username);
    }

    @Override
    public String getAccountType(Long customerId) {
        return userDao.getUserType(customerId);
    }

    @Override
    public Employee getEmployeeByUsername(String employeeUsername) {
        return userDao.getEmployeeByUsername(employeeUsername);
    }

    @Override
    public Customer getCustomerById(Long person) {
        return userDao.getCustomerById(person);
    }

}