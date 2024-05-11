package org.maslov.nback.controller.security.repository;

import org.maslov.nback.controller.security.model.UserRole;

import org.maslov.nback.controller.security.model.UserRoleType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface UserRoleRepository extends JpaRepository<UserRole, UUID> {

    Optional<UserRole> findByRole(UserRoleType type);
}
