package br.com.chronicles.model.request;

import java.util.UUID;

public record WorkUpdateDTO(Long authorId, Long workId, String title,
                            UUID[] bookGenres, UUID[] mangaGenres, String description) {
}
