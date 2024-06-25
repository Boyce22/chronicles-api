package br.com.chronicles.repository;

import br.com.chronicles.model.entity.BookGenre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface BookGenreRepository extends JpaRepository<BookGenre, UUID> {

    @Query(value = "SELECT bk FROM book_genre bk WHERE bk.isMature = false")
    List<BookGenre> findNonMatureGenres();

    @Query(value = "SELECT bk FROM book_genre bk WHERE bk.isMature = true")
    List<BookGenre> findAllMatureGenres();
}
