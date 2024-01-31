package br.com.chronicles.api.dto;

import java.time.LocalDate;

import br.com.chronicles.api.entity.Author;

public record AuthorDetailsDTO(Long id, String name, String lastName, String cpf, LocalDate birthDate) {

	public AuthorDetailsDTO(Author author) {
		this(author.getId(), author.getName(), author.getLastName(), author.getCpf(), author.getBirthDate());
	}
}
	