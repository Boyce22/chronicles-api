package br.com.chronicles.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.chronicles.model.entity.Reader;

@Repository
public interface ReaderRepository extends JpaRepository<Reader, Long> {

	@Query(value = "SELECT re FROM reader re WHERE  re.isActive = true")
	List<Reader> findAllActive();

}
