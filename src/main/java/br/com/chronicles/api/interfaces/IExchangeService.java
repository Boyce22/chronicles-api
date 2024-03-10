package br.com.chronicles.api.interfaces;

import br.com.chronicles.api.model.request.ReaderChangeRequestDTO;
import br.com.chronicles.api.model.response.AuthorDetailsDTO;

public interface IExchangeService {

	AuthorDetailsDTO grantAuthorAccessToReader(Long id, ReaderChangeRequestDTO dto);
	
}
