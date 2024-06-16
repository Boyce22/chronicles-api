package br.com.chronicles.model.response;

import br.com.chronicles.model.entity.Genre;

import java.util.UUID;

public record GenreDetailsDTO(UUID id, String name, String description) {

    public GenreDetailsDTO(Genre genre) {
        this(genre.getId(), genre.getName(), genre.getDescription());
    }
}
