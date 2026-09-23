package com.baitap.security_sb_vd1.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.baitap.security_sb_vd1.entity.User;
import com.baitap.security_sb_vd1.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService
        implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String login)
            throws UsernameNotFoundException {

        User user = userRepository
                .findByUsernameOrEmail(login, login)
                .orElseThrow(() ->
                    new UsernameNotFoundException(
                        "Không tìm thấy username/email: " + login
                    )
                );

        return new CustomUserDetails(user);
    }
}