package br.com.chronicles.model.response;

import br.com.chronicles.model.entity.Work;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public record WorkDetailsDTO(Long id, String title, List<String> genre, String description, Integer numberChapters,
                             LocalDateTime releaseDate, LocalDate createdAt, LocalDateTime updatedAt,
                             Boolean isActive) {

    public WorkDetailsDTO(Work work, List<String> genres) {
        this(work.getId(), work.getTitle(), genres, work.getDescription(), work.getFile().getNumberChapters(),
                work.getReleasedAt(), work.getCreatedAt(), work.getUpdatedAt(), work.getIsActive());
    }
}
