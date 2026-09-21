package com.baitap.security_sb_vd2.service;

import java.util.List;
import java.util.Optional;

import com.baitap.security_sb_vd2.dto.RoleDTO;

public interface RoleService {

    List<RoleDTO> findAll();

    Optional<RoleDTO> findById(Long id);

    Optional<RoleDTO> findByName(String name);

    RoleDTO save(RoleDTO roleDTO);

    void deleteById(Long id);
}