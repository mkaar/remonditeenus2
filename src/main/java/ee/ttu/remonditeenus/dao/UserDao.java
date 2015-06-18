package ee.ttu.remonditeenus.dao;

import ee.ttu.remonditeenus.model.Customer;
import ee.ttu.remonditeenus.model.Employee;
import ee.ttu.remonditeenus.model.UserAccount;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by markoka on 8.06.2015.
 */
import ee.ttu.remonditeenus.model.UserAccount;

public interface UserDao {
    UserAccount loadUserByUsername(String username);

    String getUserType(Long customerId);

    List<Customer> getAllCustomers();

    Employee getEmployeeByUsername(String employeeUsername);

    Customer getCustomerById(Long person);
}
