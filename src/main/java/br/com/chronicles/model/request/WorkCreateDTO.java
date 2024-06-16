package br.com.chronicles.model.request;

import java.util.UUID;

public record WorkCreateDTO(Long authorId, String title,
                            UUID[] bookGenres, UUID[] mangaGenres, String description) {
}
