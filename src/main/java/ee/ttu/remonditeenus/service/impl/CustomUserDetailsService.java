package ee.ttu.remonditeenus.service.impl;

/**
 * Created by markoka on 8.06.2015.
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import ee.ttu.remonditeenus.model.SecurityUser;
import ee.ttu.remonditeenus.model.UserAccount;
import ee.ttu.remonditeenus.service.UserService;

@Component
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
        UserAccount userAccount = userService.loadUserByUsername(username);
        if (userAccount == null) {
            throw new UsernameNotFoundException("UserName " + username
                    + " not found");
        }
        return new SecurityUser(userAccount);
    }


}