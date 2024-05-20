package br.com.chronicles.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.chronicles.model.entity.Author;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {

	@Query(value = "SELECT * FROM author at WHERE at.author_bl_is_active = true", nativeQuery = true)
	List<Author> findAllActive();

	@Query(value = "SELECT * FROM Author at WHERE at.author_tx_reference LIKE %:reference%", nativeQuery = true)
	List<Author> findByReference(@Param("reference") String reference);

}
