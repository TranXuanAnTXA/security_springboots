package com.baitap.security_sb_vd2.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(
        nullable = false,
        unique = true,
        columnDefinition = "NVARCHAR(100)"
    )
    private String username;

    @Column(
        nullable = false,
        unique = true,
        columnDefinition = "NVARCHAR(150)"
    )
    private String email;

    @Column(
        nullable = false,
        columnDefinition = "NVARCHAR(255)"
    )
    private String password;

    @Column(
        name = "full_name",
        columnDefinition = "NVARCHAR(150)"
    )
    private String fullName;

    @Column(
        columnDefinition = "NVARCHAR(500)"
    )
    private String images;

    @Column(nullable = false)
    private boolean enabled = true;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "role_id")
    private Role role;
}