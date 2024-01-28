package br.com.chronicles.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.chronicles.api.entity.Author;

public interface AuthorRepository extends JpaRepository<Author, Long> {

	@Query(value = "SELECT * FROM author at WHERE at.author_bl_is_active = true", nativeQuery = true)
	List<Author> findAllActive();

}
