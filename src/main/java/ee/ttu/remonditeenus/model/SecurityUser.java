package ee.ttu.remonditeenus.model;

import java.util.Collection;

import org.springframework.http.converter.json.GsonHttpMessageConverter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class SecurityUser implements UserDetails {

    private Long personId;
    private String username;
    private String password;

    public SecurityUser(UserAccount userAccount) {
        this.personId = userAccount.getUserAccount();
        this.username = userAccount.getUsername();
        this.password = userAccount.getPassw();
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {

        return password;
    }

    @Override
    public String getUsername() {

        return username;
    }

    @Override
    public boolean isAccountNonExpired() {

        return true;
    }

    @Override
    public boolean isAccountNonLocked() {

        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {

        return true;
    }

    @Override
    public boolean isEnabled() {

        return true;
    }

    public Long getCustomerId() {
        return personId;
    }

    public void setCustomerId(Long personId) {
        this.personId = personId;
    }
}