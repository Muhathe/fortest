package com.example.springBootProject.service;

import com.example.springBootProject.dtos.AuthResponse;
import com.example.springBootProject.dtos.LoginRequest;
import com.example.springBootProject.dtos.RegisterRequest;
import com.example.springBootProject.entity.User;
import com.example.springBootProject.entity.enums.Role;
import com.example.springBootProject.repository.UserRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    private final AuthenticationManager authenticationManager;

    private final com.example.springBootProject.service.JwtService jwtService;


    public AuthResponse register(RegisterRequest request) {

        if (userRepository.existsByEmail(request.getEmail())) {

            throw new RuntimeException(
                    "Bu email allaqachon mavjud"
            );
        }


        User user = User.builder()

                .firstName(request.getFirstName())

                .lastName(request.getLastName())

                .age(request.getAge())

                .email(request.getEmail())

                // Parol ochiq saqlanmaydi
                .password(
                        passwordEncoder.encode(
                                request.getPassword()
                        )
                )

                .role(Role.USER)

                .enabled(true)

                .build();


        userRepository.save(user);


        String token = jwtService.generateToken(user);


        return new AuthResponse(
                token,
                "Bearer",
                user.getRole().name()
        );
    }


    public AuthResponse login(LoginRequest request) {

        Authentication authentication =
                authenticationManager.authenticate(

                        new UsernamePasswordAuthenticationToken(
                                request.getEmail(),
                                request.getPassword()
                        )
                );


        User user = (User) authentication.getPrincipal();


        String token =
                jwtService.generateToken(user);


        return new AuthResponse(
                token,
                "Bearer",
                user.getRole().name()
        );
    }
}