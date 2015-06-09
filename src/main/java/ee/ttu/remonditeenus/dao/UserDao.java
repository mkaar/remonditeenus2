package ee.ttu.remonditeenus.dao;

import ee.ttu.remonditeenus.model.UserAccount;

import java.sql.SQLException;

/**
 * Created by markoka on 8.06.2015.
 */
import ee.ttu.remonditeenus.model.UserAccount;

public interface UserDao {
    UserAccount loadUserByUsername(String username);
}
