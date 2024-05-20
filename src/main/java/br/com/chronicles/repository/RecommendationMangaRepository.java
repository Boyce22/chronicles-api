package br.com.chronicles.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.chronicles.model.entity.RecommendationManga;

@Repository
public interface RecommendationMangaRepository extends JpaRepository<RecommendationManga, Long> {

}
