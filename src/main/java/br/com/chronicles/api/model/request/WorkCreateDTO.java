package br.com.chronicles.api.model.request;

public record WorkCreateDTO(Long authorId, String title, String[] genre, String description, Integer numberChapters) {
}
