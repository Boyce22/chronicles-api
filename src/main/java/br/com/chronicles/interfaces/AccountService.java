package br.com.chronicles.interfaces;

import br.com.chronicles.model.request.ReaderChangeRequestDTO;
import br.com.chronicles.model.response.CollaboratorDetailsDTO;

public interface AccountService {

	CollaboratorDetailsDTO grantAuthorAccessToReader(Long id, ReaderChangeRequestDTO dto);
	
}
