package com.baitap.security_sb_vd2.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.baitap.security_sb_vd2.dto.RoleDTO;
import com.baitap.security_sb_vd2.entity.Role;
import com.baitap.security_sb_vd2.mapper.RoleMapper;
import com.baitap.security_sb_vd2.repository.RoleRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;
    private final RoleMapper roleMapper;

    @Override
    public List<RoleDTO> findAll() {
        return roleRepository.findAll()
                .stream()
                .map(roleMapper::toDTO)
                .toList();
    }

    @Override
    public Optional<RoleDTO> findById(Long id) {
        return roleRepository.findById(id)
                .map(roleMapper::toDTO);
    }

    @Override
    public Optional<RoleDTO> findByName(String name) {
        return roleRepository.findByNameIgnoreCase(name)
                .map(roleMapper::toDTO);
    }

    @Override
    public RoleDTO save(RoleDTO roleDTO) {
        Role role = roleMapper.toEntity(roleDTO);
        Role savedRole = roleRepository.save(role);

        return roleMapper.toDTO(savedRole);
    }

    @Override
    public void deleteById(Long id) {
        roleRepository.deleteById(id);
    }
}