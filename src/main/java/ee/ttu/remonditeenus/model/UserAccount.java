package ee.ttu.remonditeenus.model;

/**
 * Created by markoka on 8.06.2015.
 */
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "user_account")
public class UserAccount {


    private Long userAccount;
    private String username;
    private String passw;

    @Id
    @SequenceGenerator(name = "user_account_seq", sequenceName="user_account_id", allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_account_seq")
    @Column(name = "user_account")
    public Long getUserAccount() {
        return userAccount;
    }
    public void setUserAccount(Long userAccount) {
        this.userAccount = userAccount;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassw() {
        return passw;
    }
    public void setPassw(String passw) {
        this.passw = passw;
    }


}