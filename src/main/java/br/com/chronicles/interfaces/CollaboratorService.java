package br.com.chronicles.interfaces;

import java.util.List;

import br.com.chronicles.model.entity.Collaborator;
import br.com.chronicles.model.entity.Reader;
import br.com.chronicles.model.request.CollaboratorRegisterDTO;
import br.com.chronicles.model.request.CollaboratorUpdateDTO;
import br.com.chronicles.model.request.ReaderChangeRequestDTO;
import br.com.chronicles.model.response.CollaboratorDetailsDTO;

public interface CollaboratorService {

	CollaboratorDetailsDTO register(CollaboratorRegisterDTO dto);

	CollaboratorDetailsDTO update(CollaboratorUpdateDTO dto, Long id);

	List<CollaboratorDetailsDTO> findAll();

	CollaboratorDetailsDTO disable(Long id);

	CollaboratorDetailsDTO active(Long id);

	Collaborator findById(Long id);

	CollaboratorDetailsDTO grantAuthorAccess(Reader reader, ReaderChangeRequestDTO dto);

	List<CollaboratorDetailsDTO> findByReference(String reference);
}
