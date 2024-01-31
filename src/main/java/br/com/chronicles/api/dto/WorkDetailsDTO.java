package br.com.chronicles.api.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import br.com.chronicles.api.entity.Work;

public record WorkDetailsDTO(Long id, String title, String[] genre, String description, Integer numberChapters,
		LocalDate releaseDate, LocalDate createdDate, LocalDateTime updatedDate, Boolean isActive) {

	public WorkDetailsDTO(Work work) {
		this(work.getId(), work.getTitle(), work.getGenre(), work.getDescription(), work.getNumberChapters(),
				work.getReleaseDate(), work.getCreatedDate(), work.getUpdatedDate(), work.getIsActive());
	}
}
