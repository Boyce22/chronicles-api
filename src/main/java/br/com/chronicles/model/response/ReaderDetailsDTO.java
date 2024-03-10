package br.com.chronicles.model.response;

import java.time.LocalDate;

import br.com.chronicles.model.entity.Reader;

public record ReaderDetailsDTO(Long id, String name, String lastName, LocalDate birthDate) {

	public ReaderDetailsDTO(Reader reader) {
		this(reader.getId(), reader.getName(), reader.getLastName(), reader.getBirthDate());
	}
}
