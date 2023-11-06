package com.employee.management.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.httpBasic(Customizer.withDefaults());
        httpSecurity.csrf(AbstractHttpConfigurer::disable);

        httpSecurity.authorizeHttpRequests(request -> request
                .requestMatchers("/api/v1/employee-management/auth/**")
                .permitAll()

                .requestMatchers(HttpMethod.DELETE, "/api/v1/employee-management/departments/**")
                .hasAuthority("ADMIN")

                .requestMatchers(HttpMethod.DELETE, "/api/v1/employee-management/employees/**")
                .hasAuthority("ADMIN")

                .requestMatchers(HttpMethod.DELETE, "/api/v1/employee-management/positions/**")
                .hasAuthority("ADMIN")

                .anyRequest()
                .authenticated()

        );
        return httpSecurity.build();
    }

}
