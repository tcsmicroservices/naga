package com.mongo.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class HosSecurity extends WebSecurityConfigurerAdapter{
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.httpBasic().and().authorizeRequests()
                .antMatchers(HttpMethod.GET, "/swagger-ui.html").hasAnyRole("ADMIN")
                .antMatchers(HttpMethod.POST, "/patient/bookappointment").hasAnyRole("PATIENT","ADMIN")
                .antMatchers(HttpMethod.GET, "/doctor/appointments").hasAnyRole("DOCTOR","ADMIN")
                .antMatchers(HttpMethod.GET, "/patient/myappointment").hasAnyRole("PATIENT","ADMIN")
                .antMatchers(HttpMethod.POST, "/prescription/save").hasAnyRole("DOCTOR","ADMIN")
                .antMatchers(HttpMethod.GET, "/prescription/view").hasAnyRole("DOCTOR","PATIENT","ADMIN").and().csrf().disable().headers()
                .frameOptions().disable();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("patient").password("{noop}password").roles("PATIENT").and()
                .withUser("doctor").password("{noop}password").roles("DOCTOR").and()
                .withUser("deepthi").password("{noop}password").roles("ADMIN");
    }
}