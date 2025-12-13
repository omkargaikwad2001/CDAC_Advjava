package com.example.demo.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Autowired
    CustomAccessDeniedHandler customAccessDeniedHandler;

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
            .csrf(csrf -> csrf.disable())
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/register", "/login", "/public").permitAll()
                .requestMatchers("/user").hasRole("user")   // expects ROLE_user in DB
                .requestMatchers("/admin").hasRole("admin") // expects ROLE_admin in DB
                .anyRequest().authenticated()
            )
            .formLogin(form -> form.disable()) // no default login form
            .httpBasic(httpBasic -> httpBasic.disable()) // no basic auth
            .exceptionHandling(ex -> ex.accessDeniedHandler(customAccessDeniedHandler))
            .sessionManagement(session -> session
                .maximumSessions(1)
            )
            .securityContext(securityContext -> securityContext
                .requireExplicitSave(false) // allow Spring to save SecurityContext in session automatically
            );

        return http.build();
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    UserDetailsService userDetailsService() {
        return new UserDetailsServiceImple();
    }

    @Bean
    DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(userDetailsService());
        provider.setPasswordEncoder(passwordEncoder());
        return provider;
    }

    @Bean
    AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }
}
