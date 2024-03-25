package br.com.chronicles.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.chronicles.model.entity.WorkReaderRating;

@Repository
public interface WorkReaderRatingRepository extends JpaRepository<WorkReaderRating, Long> {

	@Query(value = "SELECT work_reader_rating_id FROM work_reader_rating WHERE fk_reader_cd_id = :authorId LIMIT 1", nativeQuery = true)
	Long existsByAuthorId(Long authorId);

	@Query(value = "SELECT work_rating FROM work_reader_rating WHERE fk_work_cd_id = :workId", nativeQuery = true)
	List<Double> getRating(Long workId);

}
