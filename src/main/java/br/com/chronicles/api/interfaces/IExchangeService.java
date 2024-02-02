package br.com.chronicles.api.interfaces;

import br.com.chronicles.api.dto.AuthorDetailsDTO;
import br.com.chronicles.api.dto.ReaderChangeRequestDTO;

public interface IExchangeService {

	AuthorDetailsDTO grantAuthorAccessToReader(Long id, ReaderChangeRequestDTO dto);
	
}
