package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class SecurityConfig {

    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource){
//        System.out.println(dataSource);
        return new JdbcUserDetailsManager(dataSource);
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http.authorizeHttpRequests(config ->
                config
                        .requestMatchers("/").hasRole("USER")
                        .requestMatchers("/leaders/**").hasRole("MANAGER")
                        .requestMatchers("/admins").hasRole("ADMIN")
                        .requestMatchers("/showRegisterPage").permitAll() // Allow access to the registration page
                        .anyRequest().authenticated()
                ).formLogin(form->
                    form
                            .loginPage("/showLoginPage")
                            .loginProcessingUrl("/authenticateTheUser")
                            .permitAll()
                ).logout( logout-> logout.permitAll())
                .exceptionHandling(configure ->
                        configure
                                .accessDeniedPage("/accessDenied")
                );


            return http.build();
    }


}
