package br.com.chronicles.model.response;

import java.time.LocalDate;
import java.time.LocalDateTime;

import br.com.chronicles.model.entity.Work;

public record WorkDetailsDTO(Long id, String title, String[] genre, String description, Integer numberChapters,
		LocalDate releaseDate, LocalDate createdDate, LocalDateTime updatedDate, Boolean isActive) {

	public WorkDetailsDTO(Work work) {
		this(work.getId(), work.getTitle(), work.getGenre(), work.getDescription(), work.getFile().getNumberChapters(),
				work.getReleasedAt(), work.getCreatedAt(), work.getUpdatedAt(), work.getIsActive());
	}
}
