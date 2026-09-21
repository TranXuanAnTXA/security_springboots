package com.baitap.security_sb_vd2.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {

    private Long id;

    private String username;

    private String email;

    private String fullName;

    private String images;

    private String roleName;

    private boolean enabled;
}