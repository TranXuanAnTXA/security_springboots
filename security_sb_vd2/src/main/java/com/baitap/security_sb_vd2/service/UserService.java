package com.baitap.security_sb_vd2.service;

import java.util.List;
import java.util.Optional;

import com.baitap.security_sb_vd2.dto.UserDTO;

public interface UserService {

    List<UserDTO> findAll();

    Optional<UserDTO> findById(Long id);

    Optional<UserDTO> findByUsername(String username);

    Optional<UserDTO> findByEmail(String email);

    Optional<UserDTO> findByUsernameOrEmail(String login);

    UserDTO save(UserDTO userDTO);

    void deleteById(Long id);
}