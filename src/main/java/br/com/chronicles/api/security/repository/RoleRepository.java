package br.com.chronicles.api.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.chronicles.api.security.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

}
