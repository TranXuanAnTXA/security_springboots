package com.baitap.security_sb_vd1.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.baitap.security_sb_vd1.dto.UserDTO;
import com.baitap.security_sb_vd1.entity.User;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(
        target = "roleName",
        source = "role.name"
    )
    UserDTO toDTO(User user);
}