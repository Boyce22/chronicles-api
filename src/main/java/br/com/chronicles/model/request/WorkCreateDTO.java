package br.com.chronicles.model.request;

public record WorkCreateDTO(Long authorId, String title, String[] genre, String description, Integer numberChapters) {
}
