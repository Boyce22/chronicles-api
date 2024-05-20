package br.com.chronicles.model.response;

import java.time.LocalDateTime;

import br.com.chronicles.model.entity.Comentary;

public record ComentaryDetailsDTO(String content, LocalDateTime createdAt) {

	public ComentaryDetailsDTO(Comentary comentary) {
		this(comentary.getContent(), comentary.getCreatedAt());
	}
}
