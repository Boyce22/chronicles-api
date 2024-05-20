package br.com.chronicles.model.response;

import br.com.chronicles.model.entity.WorkReaderRating;

public record WorkRatingDetailsDTO(Long id, Long readerId, Long workId, Double rating) {

	public WorkRatingDetailsDTO(WorkReaderRating workRating) {
		this(workRating.getId(), workRating.getReader().getId(), workRating.getWork().getId(), workRating.getRating());
	}
}
