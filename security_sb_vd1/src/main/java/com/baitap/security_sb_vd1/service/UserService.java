package com.baitap.security_sb_vd1.service;

import com.baitap.security_sb_vd1.dto.UserDTO;

public interface UserService {

    UserDTO findById(Long id);
}