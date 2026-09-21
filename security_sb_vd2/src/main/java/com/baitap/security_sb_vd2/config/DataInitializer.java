package com.baitap.security_sb_vd2.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.baitap.security_sb_vd2.entity.Role;
import com.baitap.security_sb_vd2.entity.User;
import com.baitap.security_sb_vd2.repository.RoleRepository;
import com.baitap.security_sb_vd2.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {

    private final RoleRepository roleRepository;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) {

        // =========================
        // 1. Tạo ROLE_USER
        // =========================

        Role userRole = roleRepository
                .findByNameIgnoreCase("ROLE_USER")
                .orElseGet(() -> {
                    Role role = new Role();
                    role.setName("ROLE_USER");
                    return roleRepository.save(role);
                });

        // =========================
        // 2. Tạo ROLE_ADMIN
        // =========================

        Role adminRole = roleRepository
                .findByNameIgnoreCase("ROLE_ADMIN")
                .orElseGet(() -> {
                    Role role = new Role();
                    role.setName("ROLE_ADMIN");
                    return roleRepository.save(role);
                });

        // =========================
        // 3. Tạo user mẫu
        // =========================

        if (userRepository.findByUsername("user01").isEmpty()) {

            User user = new User();

            user.setUsername("user01");
            user.setEmail("user01@gmail.com");

            user.setPassword(
                    passwordEncoder.encode("123456")
            );

            user.setFullName("User 01");
            user.setImages("/images/default-user.png");
            user.setEnabled(true);
            user.setRole(userRole);

            userRepository.save(user);
        }

        // =========================
        // 4. Tạo admin mẫu
        // =========================

        if (userRepository.findByUsername("admin01").isEmpty()) {

            User admin = new User();

            admin.setUsername("admin01");
            admin.setEmail("admin01@gmail.com");

            admin.setPassword(
                    passwordEncoder.encode("123456")
            );

            admin.setFullName("Administrator");
            admin.setImages("/images/default-admin.png");
            admin.setEnabled(true);
            admin.setRole(adminRole);

            userRepository.save(admin);
        }
    }
}