package br.com.chronicles.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.chronicles.model.entity.MangaGenre;

import java.util.List;
import java.util.UUID;

@Repository
public interface MangaGenreRepository extends JpaRepository<MangaGenre, UUID> {

    @Query(value = "SELECT mg FROM manga_genre mg WHERE mg.isMature = false")
    List<MangaGenre> findNonMatureGenres();

    @Query(value = "SELECT mg FROM manga_genre mg WHERE mg.isMature = true")
    List<MangaGenre> findAllMatureGenres();

}
