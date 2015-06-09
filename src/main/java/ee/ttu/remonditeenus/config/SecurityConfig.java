package ee.ttu.remonditeenus.config;

/**
 * Created by markoka on 8.06.2015.
 */
import javax.sql.DataSource;

import ee.ttu.remonditeenus.service.impl.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled=true, prePostEnabled=true)
@ComponentScan(basePackages = "ee.ttu.remonditeenus")
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private static Integer STRENGTH = 11;
    private static String USER_QUERY = "select username, passw, subject_fk from user_account where username=?";

    @Autowired
    DataSource dataSource;

    @Autowired
    private CustomUserDetailsService customUserDetailsService;

    @Bean(name="myAuthenticationManager")
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth)
            throws Exception {
        auth.userDetailsService(customUserDetailsService).passwordEncoder(getEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/remonditeenus", "/remonditeenus/**").authenticated()
                .and()
                .formLogin().loginPage("/login").defaultSuccessUrl("/remonditeenus/")
                .failureUrl("/login?error")//
                .usernameParameter( "username" )
                .passwordParameter( "password" )
                .permitAll()
                .and()
                .csrf().disable();
    }
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers( "/frontend/**" );
    }

    @Bean(name = "encoder")
    public BCryptPasswordEncoder getEncoder() {
        return new BCryptPasswordEncoder(STRENGTH);
    }
}