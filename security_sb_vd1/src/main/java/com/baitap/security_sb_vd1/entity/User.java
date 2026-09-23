package com.baitap.security_sb_vd1.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(
    name = "users",
    uniqueConstraints = {
        @UniqueConstraint(
            name = "uk_users_username",
            columnNames = "username"
        ),
        @UniqueConstraint(
            name = "uk_users_email",
            columnNames = "email"
        )
    }
)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(
        nullable = false,
        unique = true,
        length = 50,
        columnDefinition = "nvarchar(50)"
    )
    private String username;

    @Column(
        nullable = false,
        unique = true,
        length = 150,
        columnDefinition = "nvarchar(150)"
    )
    private String email;

    @Column(
        nullable = false,
        length = 255,
        columnDefinition = "nvarchar(255)"
    )
    private String password;

    @Column(
        name = "full_name",
        length = 150,
        columnDefinition = "nvarchar(150)"
    )
    private String fullName;

    @Column(
        length = 500,
        columnDefinition = "nvarchar(500)"
    )
    private String images;

    @Column(nullable = false)
    @Builder.Default
    private boolean enabled = true;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(
        name = "role_id",
        nullable = false
    )
    private Role role;
}