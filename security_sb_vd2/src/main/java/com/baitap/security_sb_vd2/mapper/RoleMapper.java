package com.baitap.security_sb_vd2.mapper;

import org.mapstruct.Mapper;

import com.baitap.security_sb_vd2.dto.RoleDTO;
import com.baitap.security_sb_vd2.entity.Role;

@Mapper(componentModel = "spring")
public interface RoleMapper {

    RoleDTO toDTO(Role role);

    Role toEntity(RoleDTO roleDTO);
}