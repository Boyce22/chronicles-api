package br.com.chronicles.api.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.chronicles.api.security.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
