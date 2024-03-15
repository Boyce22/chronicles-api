package br.com.chronicles.interfaces;

import br.com.chronicles.model.request.ReaderChangeRequestDTO;
import br.com.chronicles.model.response.AuthorDetailsDTO;

public interface ExchangeServiceImpl {

	AuthorDetailsDTO grantAuthorAccessToReader(Long id, ReaderChangeRequestDTO dto);
	
}
