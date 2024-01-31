package br.com.chronicles.api.interfaces;

import java.util.List;

import br.com.chronicles.api.dto.AuthorDetailsDTO;
import br.com.chronicles.api.dto.AuthorRegisterDTO;
import br.com.chronicles.api.dto.AuthorUpdateDTO;
import br.com.chronicles.api.entity.Author;

public interface IAuthorService {

	AuthorDetailsDTO register(AuthorRegisterDTO dto);

	AuthorDetailsDTO update(AuthorUpdateDTO dto, Long id);

	List<AuthorDetailsDTO> findAll();

	void disable(Long id);

	void active(Long id);

	Author findById(Long id);
}
