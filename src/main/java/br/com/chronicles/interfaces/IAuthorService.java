package br.com.chronicles.interfaces;

import java.util.List;

import br.com.chronicles.model.entity.Author;
import br.com.chronicles.model.entity.Reader;
import br.com.chronicles.model.request.AuthorRegisterDTO;
import br.com.chronicles.model.request.AuthorUpdateDTO;
import br.com.chronicles.model.request.ReaderChangeRequestDTO;
import br.com.chronicles.model.response.AuthorDetailsDTO;

public interface IAuthorService {

	AuthorDetailsDTO register(AuthorRegisterDTO dto);

	AuthorDetailsDTO update(AuthorUpdateDTO dto, Long id);

	List<AuthorDetailsDTO> findAll();

	void disable(Long id);

	void active(Long id);

	Author findById(Long id);

	AuthorDetailsDTO grantAuthorAccess(Reader reader, ReaderChangeRequestDTO dto);
}
