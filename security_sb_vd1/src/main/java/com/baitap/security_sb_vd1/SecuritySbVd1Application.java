package com.baitap.security_sb_vd1;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.baitap.security_sb_vd1.entity.Role;
import com.baitap.security_sb_vd1.entity.User;
import com.baitap.security_sb_vd1.repository.RoleRepository;
import com.baitap.security_sb_vd1.repository.UserRepository;

@SpringBootApplication
public class SecuritySbVd1Application {

    public static void main(String[] args) {

        SpringApplication.run(
            SecuritySbVd1Application.class,
            args
        );
    }

    @Bean
    CommandLineRunner init(
            RoleRepository roleRepository,
            UserRepository userRepository,
            PasswordEncoder passwordEncoder) {

        return args -> {

            // Tạo ROLE_USER
            Role userRole = roleRepository
                    .findByName("ROLE_USER")
                    .orElseGet(() ->
                        roleRepository.save(
                            Role.builder()
                                .name("ROLE_USER")
                                .build()
                        )
                    );

            // Tạo user mẫu
            if (userRepository
                    .findByUsername("user")
                    .isEmpty()) {

                User user = User.builder()
                        .username("user")
                        .email("user@gmail.com")
                        .password(
                            passwordEncoder.encode("123456")
                        )
                        .fullName("Trần Xuân An")
                        .images("/images/user.png")
                        .role(userRole)
                        .enabled(true)
                        .build();

                userRepository.save(user);

                System.out.println(
                    "================================="
                );
                System.out.println(
                    "ĐÃ TẠO USER MẪU"
                );
                System.out.println(
                    "Username: user"
                );
                System.out.println(
                    "Email: user@gmail.com"
                );
                System.out.println(
                    "Password: 123456"
                );
                System.out.println(
                    "Role: ROLE_USER"
                );
                System.out.println(
                    "================================="
                );
            }
        };
    }
}