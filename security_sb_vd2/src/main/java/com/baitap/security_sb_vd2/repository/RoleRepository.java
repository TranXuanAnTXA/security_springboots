package com.baitap.security_sb_vd2.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.baitap.security_sb_vd2.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Optional<Role> findByNameIgnoreCase(String name);
}