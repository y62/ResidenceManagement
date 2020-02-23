package com.example.bas.Security;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@Configuration
@EnableAutoConfiguration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    DataSource dataSource;

    @Autowired
    public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication().dataSource(dataSource)
                .usersByUsernameQuery("select username,password, enabled from users where username=?")
                .authoritiesByUsernameQuery("select username, role from user_roles where username=?");
    }
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/").permitAll().antMatchers("/adminFrontPage", "/consumptionCreate", "/consumptionUpdate", "/consumptionDelete", "/user", "/userCreate",
                "/userUpdate", "/userDelete", "/news/newsUpdate/1", "/residenceCreate", "/residenceDelete", "/residenceUpdate", "/residence", "/role", "/roleCreate", "/roleUpdate",
                "/roleDelete").hasRole("ADMIN")
                .anyRequest().authenticated().and().formLogin().loginPage("/login").permitAll().and().logout()
                .permitAll();
        http.exceptionHandling().accessDeniedPage("/404");
    }

    /**
     * Vi skal have PasswordEncoder med i Spring Security 5 pga. mere sikkerhed i encoding/decoding passwords.
     * Hvis man fravælger PasswordEncoder, får man java.lang.IllegalArgumentException: There is no PasswordEncoder mapped for the id "null"
     */
    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }
}
