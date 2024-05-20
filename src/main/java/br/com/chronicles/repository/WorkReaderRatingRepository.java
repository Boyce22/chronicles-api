package br.com.chronicles.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.chronicles.model.entity.WorkReaderRating;

@Repository
public interface WorkReaderRatingRepository extends JpaRepository<WorkReaderRating, Long> {

	@Query(value = "SELECT wk FROM work_reader_rating wk WHERE wk.reader.id = :readerId")
	Long existsByReaderId(@Param("readerId") Long readerId);

	@Query(value = "SELECT wk FROM work_reader_rating wk WHERE wk.work.id = :workId")
	List<Double> getRating(@Param("workId") Long workId);

}
