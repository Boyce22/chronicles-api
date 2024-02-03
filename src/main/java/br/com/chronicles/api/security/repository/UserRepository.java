package br.com.chronicles.api.security.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.chronicles.api.security.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{

	@Query(value = "SELECT * FROM users us WHERE us.userRepository", nativeQuery = true)
	Optional<User> findByEmail(String email);
}
