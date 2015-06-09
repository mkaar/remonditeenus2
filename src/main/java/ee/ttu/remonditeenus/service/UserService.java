package ee.ttu.remonditeenus.service;

import ee.ttu.remonditeenus.dao.UserDao;
import ee.ttu.remonditeenus.dao.impl.UserDaoImpl;
import ee.ttu.remonditeenus.model.UserAccount;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

/**
 * Created by markoka on 8.06.2015.
 */
import ee.ttu.remonditeenus.model.UserAccount;

public interface UserService {
    UserAccount loadUserByUsername(String username);
}