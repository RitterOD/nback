package org.maslov.nback.controller.security.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = UserRole.TABLE_NAME)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserRole {
    public static final String TABLE_NAME = "nback_user_role";

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "role", unique = true)
    @Enumerated(value = EnumType.STRING)
    private UserRoleType role;
}
