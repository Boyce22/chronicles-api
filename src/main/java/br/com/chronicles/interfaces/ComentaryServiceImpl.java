package br.com.chronicles.interfaces;

import br.com.chronicles.model.response.ComentaryDetailsDTO;

public interface ComentaryServiceImpl {

	ComentaryDetailsDTO create(String content, Long workId, Long readerId);
}