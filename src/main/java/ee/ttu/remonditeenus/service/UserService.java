package ee.ttu.remonditeenus.service;

import ee.ttu.remonditeenus.dao.UserDao;
import ee.ttu.remonditeenus.dao.impl.UserDaoImpl;
import ee.ttu.remonditeenus.model.*;
import jdk.nashorn.internal.runtime.UserAccessorProperty;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

/**
 * Created by markoka on 8.06.2015.
 */
import ee.ttu.remonditeenus.model.UserAccount;

public interface UserService {
    UserAccount loadUserByUsername(String username);

    String getAccountType(Long customerId);

    Employee getEmployeeByUsername(String employeeUsername);

    Customer getCustomerById(Long person);
}