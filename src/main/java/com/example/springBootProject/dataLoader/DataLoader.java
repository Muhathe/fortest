package com.example.springBootProject.dataLoader;

import com.example.springBootProject.entity.User;
import com.example.springBootProject.entity.enums.Role;
import com.example.springBootProject.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataLoader implements CommandLineRunner {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;


    @Override
    public void run(String... args) {

        createAdmin();

        createUser();
    }


    private void createAdmin() {

        if (!userRepository.existsByEmail("admin@gmail.com")) {

            User admin = User.builder()

                    .firstName("Admin")
                    .lastName("Adminov")
                    .age(25)

                    .email("admin@gmail.com")

                    .password(
                            passwordEncoder.encode("1234")
                    )

                    .role(Role.ADMIN)

                    .enabled(true)

                    .build();


            userRepository.save(admin);
        }
    }

//ishladi
    private void createUser() {

        if (!userRepository.existsByEmail("user@gmail.com")) {

            User user = User.builder()

                    .firstName("User")
                    .lastName("Userov")
                    .age(20)

                    .email("user@gmail.com")

                    .password(
                            passwordEncoder.encode("1234")
                    )

                    .role(Role.USER)

                    .enabled(true)

                    .build();


            userRepository.save(user);
        }
    }
}