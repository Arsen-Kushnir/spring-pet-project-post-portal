package com.arsenkushnir.postportal.config;

import com.arsenkushnir.postportal.exception.AuthenticationFailureHandler;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    private final AuthenticationFailureHandler authenticationFailureHandler;

    private final UserDetailsService userDetailsService;

    private final BCryptPasswordEncoder passwordEncoder;

    public SecurityConfiguration(AuthenticationFailureHandler authenticationFailureHandler,
                                 @Qualifier("userServiceImpl") UserDetailsService userDetailsService,
                                 BCryptPasswordEncoder passwordEncoder) {

        this.authenticationFailureHandler = authenticationFailureHandler;
        this.userDetailsService = userDetailsService;
        this.passwordEncoder = passwordEncoder;
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/accounts/index")
                .failureHandler(authenticationFailureHandler)
                .permitAll()
                .and()
                .logout()
                .permitAll()
                .and()
                .authorizeRequests()
                .antMatchers("/accounts", "/posts/search")
                .permitAll()
                .and()
                .authorizeRequests()
                .antMatchers("/accounts/all", "/accounts/delete/*")
                .hasRole("ADMIN")
                .and()
                .authorizeRequests()
                .antMatchers("/accounts/**", "/posts/**")
                .authenticated()
                .and()
                .authorizeRequests()
                .anyRequest()
                .permitAll();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
    }
}
