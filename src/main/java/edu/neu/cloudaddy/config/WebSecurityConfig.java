package edu.neu.cloudaddy.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
         http
            .csrf().disable()
            .authorizeRequests()
                .antMatchers("/", "/home","/assets/**","/favicon.ico").permitAll()
                .anyRequest().authenticated()
                .and()
            .formLogin()
                .loginPage("/login")
                .permitAll()
                .and()
            .logout()
                .permitAll()
            ;
    }

    @Autowired
	DataSource dataSource;
    
    String user = "select u.username,p.password, 1 AS enabled from users u, users_password p" +
    		" where u.username=? and u.id=p.id";
    
    String authority="select username, authority from authorities where username = ?";
    
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
       /* auth
            .inMemoryAuthentication()
                .withUser("user").password("password").roles("USER");
                */
    	auth.jdbcAuthentication().dataSource(dataSource)
		.usersByUsernameQuery(user).authoritiesByUsernameQuery(authority);
    }
}
