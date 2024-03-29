package br.com.chronicles.model.response;

import java.time.LocalDate;

import br.com.chronicles.model.entity.Author;

public record AuthorDetailsDTO(Long id, String name, String lastName, String cpf, LocalDate birthDate) {

	public AuthorDetailsDTO(Author author) {
		this(author.getId(), author.getName(), author.getLastName(), author.getCpf(), author.getBirthDate());
	}
}
	