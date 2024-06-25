package br.com.chronicles.model.response;

import br.com.chronicles.model.entity.BookGenre;
import br.com.chronicles.model.entity.MangaGenre;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface WorkNonWithChapters {
    Long getId();

    String getTitle();

    String getDescription();

    LocalDateTime getReleasedAt();

    Double getRating();

    LocalDate getCreatedAt();

    LocalDateTime getUpdatedAt();

    boolean getIsActive();

    boolean getIsMature();

    List<BookGenre> getBookGenres();

    List<MangaGenre> getMangaGenres();

    String getCollaborator();
}
