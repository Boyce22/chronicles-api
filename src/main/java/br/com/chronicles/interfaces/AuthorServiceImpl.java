package br.com.chronicles.interfaces;

import java.util.List;

import br.com.chronicles.model.entity.Author;
import br.com.chronicles.model.entity.Reader;
import br.com.chronicles.model.request.AuthorRegisterDTO;
import br.com.chronicles.model.request.AuthorUpdateDTO;
import br.com.chronicles.model.request.ReaderChangeRequestDTO;
import br.com.chronicles.model.response.AuthorDetailsDTO;
import br.com.chronicles.model.response.DefaultResponse;

public interface AuthorServiceImpl {

	AuthorDetailsDTO register(AuthorRegisterDTO dto);

	AuthorDetailsDTO update(AuthorUpdateDTO dto, Long id);

	List<AuthorDetailsDTO> findAll();

	DefaultResponse disable(Long id);

	DefaultResponse active(Long id);

	Author findById(Long id);

	AuthorDetailsDTO grantAuthorAccess(Reader reader, ReaderChangeRequestDTO dto);

	List<AuthorDetailsDTO> findByReference(String reference);
}
