package br.com.chronicles.api.dto;

import java.time.LocalDate;

import br.com.chronicles.api.entity.Reader;

public record ReaderDetailsDTO(Long id, String name, String lastName, LocalDate birthDate) {

	public ReaderDetailsDTO(Reader reader) {
		this(reader.getId(), reader.getName(), reader.getLastName(), reader.getBirthDate());
	}
}
