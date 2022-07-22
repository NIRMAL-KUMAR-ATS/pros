package com.ypp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ypp.model.role.Role;
import com.ypp.model.role.RoleName;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
	Optional<Role> findByName(RoleName name);
}
