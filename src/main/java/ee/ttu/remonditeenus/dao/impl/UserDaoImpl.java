package ee.ttu.remonditeenus.dao.impl;

/**
 * Created by markoka on 8.06.2015.
 */
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ee.ttu.remonditeenus.model.Customer;
import ee.ttu.remonditeenus.model.Employee;
import ee.ttu.remonditeenus.model.Person;
import org.springframework.stereotype.Repository;

import ee.ttu.remonditeenus.dao.UserDao;
import ee.ttu.remonditeenus.model.UserAccount;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    EntityManager em;

    @Override
    public UserAccount loadUserByUsername(String username) {
        return (UserAccount)em.createQuery("from UserAccount UA where UA.username = :username")
                .setParameter("username", username)
                .getSingleResult();
    }

    @Override
    public String getUserType(Long customerId) {
        Employee person;
        try{
            person = (Employee)em.createQuery("from Employee where employee = :customerId ").setParameter("customerId", customerId).getSingleResult();
        } catch (Exception e){
            person = null;
        }

        if(person == null){
            return "CUSTOMER";
        } else {
            return "EMPLOYEE";
        }
    }

    @Override
    public List<Customer> getAllCustomers() {
        return em.createQuery("from Customer").getResultList();
    }

    @Override
    public Employee getEmployeeByUsername(String employeeUsername) {
        UserAccount user = (UserAccount)em.createQuery("from UserAccount where username = :username").setParameter("username", employeeUsername).getSingleResult();
        return (Employee)em.createQuery("from Employee where employee = :id").setParameter("id", user.getUserAccount()).getSingleResult();
    }

    @Override
    public Customer getCustomerById(Long person) {
        return (Customer)em.createQuery("from Customer where subject_fk = :id").setParameter("id", person).getSingleResult();
    }

}