package br.com.chronicles.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.chronicles.model.entity.RecommendationBook;

@Repository
public interface RecommentationBookRepository extends JpaRepository<RecommendationBook, Long> {

	@Query(value = "SELECT r FROM recommendation_book r WHERE r.reader.id = :readerId")
	RecommendationBook findByReaderId(@Param("readerId") Long readerId);

}
