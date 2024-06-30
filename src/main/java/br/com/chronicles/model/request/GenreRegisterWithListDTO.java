package br.com.chronicles.model.request;

import java.util.List;

public record GenreRegisterWithListDTO(String name, String description, List<GenreRegisterDTO> genres) {
}
