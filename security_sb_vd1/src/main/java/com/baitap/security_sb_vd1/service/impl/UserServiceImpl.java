package com.baitap.security_sb_vd1.service.impl;

import org.springframework.stereotype.Service;

import com.baitap.security_sb_vd1.dto.UserDTO;
import com.baitap.security_sb_vd1.entity.User;
import com.baitap.security_sb_vd1.mapper.UserMapper;
import com.baitap.security_sb_vd1.repository.UserRepository;
import com.baitap.security_sb_vd1.service.UserService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final UserMapper userMapper;

    @Override
    public UserDTO findById(Long id) {

        User user = userRepository
                .findById(id)
                .orElseThrow();

        return userMapper.toDTO(user);
    }
}