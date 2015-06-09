package ee.ttu.remonditeenus.dao.impl;

/**
 * Created by markoka on 8.06.2015.
 */
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import ee.ttu.remonditeenus.dao.UserDao;
import ee.ttu.remonditeenus.model.UserAccount;

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

}