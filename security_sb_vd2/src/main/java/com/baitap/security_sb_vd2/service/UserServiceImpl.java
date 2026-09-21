package com.baitap.security_sb_vd2.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.baitap.security_sb_vd2.dto.UserDTO;
import com.baitap.security_sb_vd2.mapper.UserMapper;
import com.baitap.security_sb_vd2.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public List<UserDTO> findAll() {
        return userRepository.findAll()
                .stream()
                .map(userMapper::toDTO)
                .toList();
    }

    @Override
    public Optional<UserDTO> findById(Long id) {
        return userRepository.findById(id)
                .map(userMapper::toDTO);
    }

    @Override
    public Optional<UserDTO> findByUsername(String username) {
        return userRepository.findByUsername(username)
                .map(userMapper::toDTO);
    }

    @Override
    public Optional<UserDTO> findByEmail(String email) {
        return userRepository.findByEmail(email)
                .map(userMapper::toDTO);
    }

    @Override
    public Optional<UserDTO> findByUsernameOrEmail(String login) {
        return userRepository
                .findByUsernameOrEmail(login, login)
                .map(userMapper::toDTO);
    }

    @Override
    public UserDTO save(UserDTO userDTO) {
        throw new UnsupportedOperationException(
                "Chức năng save User chưa được sử dụng trong Example 2"
        );
    }

    @Override
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }
}