package br.com.chronicles.interfaces;

import br.com.chronicles.model.response.CommentaryDetailsDTO;

public interface CommentaryService {

	CommentaryDetailsDTO create(String content, Long workId, Long readerId);
}
