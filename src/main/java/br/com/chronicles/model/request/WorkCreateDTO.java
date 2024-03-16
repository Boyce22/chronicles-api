package br.com.chronicles.model.request;

import org.springframework.web.multipart.MultipartFile;

public record WorkCreateDTO(Long authorId, String title, 
		String[] genre, String description, Integer numberChapters, MultipartFile pdf) {
}
