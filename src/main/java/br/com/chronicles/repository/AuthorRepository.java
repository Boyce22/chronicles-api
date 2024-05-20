package br.com.chronicles.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.chronicles.model.entity.Author;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {

	@Query(value = "SELECT at FROM author at WHERE at.isActive = true")
	List<Author> findAllActive();

	@Query(value = "SELECT at FROM author at WHERE at.reference LIKE %:reference%")
	List<Author> findByReference(@Param("reference") String reference);

}
