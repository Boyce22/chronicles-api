package br.com.chronicles.model.response;

import java.time.LocalDateTime;

import br.com.chronicles.model.entity.Commentary;

public record CommentaryDetailsDTO(String content, LocalDateTime createdAt) {

	public CommentaryDetailsDTO(Commentary commentary) {
		this(commentary.getContent(), commentary.getCreatedAt());
	}
}
