package br.com.chronicles.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.chronicles.interfaces.AuthorServiceImpl;
import br.com.chronicles.model.entity.Author;
import br.com.chronicles.model.entity.Reader;
import br.com.chronicles.model.request.AuthorRegisterDTO;
import br.com.chronicles.model.request.AuthorUpdateDTO;
import br.com.chronicles.model.request.ReaderChangeRequestDTO;
import br.com.chronicles.model.response.AuthorDetailsDTO;
import br.com.chronicles.model.response.DefaultResponse;
import br.com.chronicles.repository.AuthorRepository;

@Service
public class AuthorService implements AuthorServiceImpl {

	private final AuthorRepository authorRepository;

	public AuthorService(AuthorRepository authorRepository) {
		this.authorRepository = authorRepository;
	}

	@Override
	public AuthorDetailsDTO register(AuthorRegisterDTO dto) {
		return new AuthorDetailsDTO(authorRepository.save(Author.registrar(dto)));
	}

	@Override
	public AuthorDetailsDTO update(AuthorUpdateDTO dto, Long id) {
		return new AuthorDetailsDTO(authorRepository.save(findById(id).update(dto)));
	}

	@Override
	public List<AuthorDetailsDTO> findAll() {
		return authorRepository.findAllActive().stream().map(AuthorDetailsDTO::new).toList();
	}
	
	@Override
	public List<AuthorDetailsDTO> findByReference(String reference){
		return authorRepository.findByReference(reference).stream().map(AuthorDetailsDTO::new).toList();
	}

	@Override
	public DefaultResponse disable(Long id) {
		Author author = findById(id);
		if (author.getIsActive()) {
			authorRepository.save(author.disable());
			return new DefaultResponse("User disabled successfully");
		}
		return new DefaultResponse("Error");
	}

	@Override
	public DefaultResponse active(Long id) {
		Author author = findById(id);
		if (!author.getIsActive()) {
			authorRepository.save(author.active());
			return new DefaultResponse("User activated successfully");
		}
		return new DefaultResponse("Error");
	}

	@Override
	public AuthorDetailsDTO grantAuthorAccess(Reader reader, ReaderChangeRequestDTO dto) {
		return new AuthorDetailsDTO(authorRepository.save(Author.grantAuthorAccessToReader(reader, dto)));
	}

	@Override
	public Author findById(Long id) {
		return authorRepository.findById(id).orElseThrow(() -> new RuntimeException("Autor não encontrado"));
	}

}
