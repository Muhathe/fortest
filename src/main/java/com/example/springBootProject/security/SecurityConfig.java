package com.example.springBootProject.security;

import com.example.springBootProject.service.JwtAuthenticationFilter;
import com.example.springBootProject.service.CustomUserDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@RequiredArgsConstructor
public class SecurityConfig {

    private final JwtAuthenticationFilter jwtAuthenticationFilter;

    private final CustomUserDetailsService userDetailsService;

    @Value("${security.whitelist}")
    private String[] whitelist;


    @Bean
    public SecurityFilterChain securityFilterChain(
            HttpSecurity http,
            AuthenticationProvider authenticationProvider
    ) throws Exception {

        http

                // REST API uchun CSRF kerak emas
                .csrf(csrf -> csrf.disable())


                // Session ishlatmaymiz
                .sessionManagement(session ->
                        session.sessionCreationPolicy(
                                SessionCreationPolicy.STATELESS
                        )
                )


                // URL permissions
                .authorizeHttpRequests(auth -> auth

                        // Login va register ochiq
                        .requestMatchers(
                                "/auth/login",
                                "/auth/register"
                        ).permitAll()


                        // Faqat ADMIN
                        .requestMatchers("/admin/**")
                        .hasRole("ADMIN")


                        // USER yoki ADMIN
                        .requestMatchers("/user/**")
                        .hasAnyRole("USER", "ADMIN")

                        .requestMatchers(whitelist).permitAll()

                        // Qolgan hammasi authentication talab qiladi
                        .anyRequest()
                        .authenticated()
                )


                .authenticationProvider(authenticationProvider)


                // JWT filter login filterdan oldin ishlaydi
                .addFilterBefore(
                        jwtAuthenticationFilter,
                        UsernamePasswordAuthenticationFilter.class
                );


        return http.build();
    }


    @Bean
    public AuthenticationProvider authenticationProvider(
            PasswordEncoder passwordEncoder
    ) {

        DaoAuthenticationProvider provider =
                new DaoAuthenticationProvider(userDetailsService);

        provider.setPasswordEncoder(passwordEncoder);

        return provider;
    }


    @Bean
    public AuthenticationManager authenticationManager(
            AuthenticationConfiguration configuration
    ) throws Exception {

        return configuration.getAuthenticationManager();
    }


    @Bean
    public PasswordEncoder passwordEncoder() {

        return new BCryptPasswordEncoder();
    }
}