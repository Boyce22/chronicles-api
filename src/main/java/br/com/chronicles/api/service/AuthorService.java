package br.com.chronicles.api.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import br.com.chronicles.api.dto.AuthorDetailsDTO;
import br.com.chronicles.api.dto.AuthorRegisterDTO;
import br.com.chronicles.api.dto.AuthorUpdateDTO;
import br.com.chronicles.api.dto.ReaderChangeRequestDTO;
import br.com.chronicles.api.entity.Author;
import br.com.chronicles.api.entity.Reader;
import br.com.chronicles.api.interfaces.IAuthorService;
import br.com.chronicles.api.repository.AuthorRepository;

@Service
public class AuthorService implements IAuthorService {

	private final AuthorRepository authorRepository;

	public AuthorService(AuthorRepository authorRepository) {
		this.authorRepository = authorRepository;
	}

	@Override
	public AuthorDetailsDTO register(AuthorRegisterDTO dto) {
		return new AuthorDetailsDTO(authorRepository.save(new Author().registrar(dto)));
	}

	@Override
	public AuthorDetailsDTO update(AuthorUpdateDTO dto, Long id) {
		return new AuthorDetailsDTO(authorRepository.save(findById(id).update(dto)));
	}

	@Override
	public List<AuthorDetailsDTO> findAll() {
		return authorRepository.findAllActive().stream().map(AuthorDetailsDTO::new).collect(Collectors.toList());
	}

	@Override
	public void disable(Long id) {
		authorRepository.save(findById(id).disable());
	}

	@Override
	public void active(Long id) {
		Author author = findById(id);
		if (!author.getIsActive()) {
			authorRepository.save(author.active());
		}
	}
	
	@Override
	public AuthorDetailsDTO grantAuthorAccess(Reader reader, ReaderChangeRequestDTO dto) {
		return new AuthorDetailsDTO(authorRepository.save(new Author().grantAuthorAccessToReader(reader, dto)));
	}

	@Override
	public Author findById(Long id) {
		return authorRepository.findById(id).orElseThrow(() -> new RuntimeException("Autor não encontrado"));
	}
	
	

}
