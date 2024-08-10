package com.telcel.dswi.notificacion.oym.NotificacionOym.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Description;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

/**
 * Clase que implementa la seguridad de la aplicacion con autenticación básica
 *
 * @author AxelCorreaE
 * @version 1.0
 */
@Configuration
@EnableWebSecurity
public class Seguridad {

    @Value("${usr.security}")
    private String user;
    @Value("${pass.security}")
    private String pass;


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests((requests) -> requests
                        .requestMatchers("/a/**").hasRole("USER")
                        .requestMatchers("/b/**").hasRole("ADMIN")
                        .anyRequest().authenticated()

                )
                .httpBasic(Customizer.withDefaults());
        return http.build();
    }

    /*
    @Bean
    public UserDetailsService userDetailsService() {
        /*
        UserDetails user = User.withDefaultPasswordEncoder()
                .username("identidad2")
                .password("password")
                .roles("USER")
                .build();

        UserDetails admin = User.withDefaultPasswordEncoder()
                .username(this.user)
                .password(this.pass)
                .roles("ADMIN")
                .build();

        //return new InMemoryUserDetailsManager(user, admin);
        return new InMemoryUserDetailsManager(admin);
    }*/

    /**
     * @
     * @return
     */
    @Bean
    public UserDetailsService users() {

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encodedPassword = encoder.encode(this.pass);
        /*
        UserDetails user = User.withDefaultPasswordEncoder()
                .username("identidad2")
                .password("password")
                .roles("USER")
                .build();*/
        UserDetails admin = User.builder()
                .username(this.user)
                .password(encodedPassword)
                .roles("ADMIN")
                .build();
        return new InMemoryUserDetailsManager(admin);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
