package br.com.chronicles.api.dto;

public record WorkCreateDTO(Long authorId, String title, String[] genre, String description, Integer numberChapters) {
}
