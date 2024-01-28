package br.com.chronicles.api.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.chronicles.api.dto.AuthorDetailsDTO;
import br.com.chronicles.api.dto.AuthorRegisterDTO;
import br.com.chronicles.api.dto.AuthorUpdateDTO;
import br.com.chronicles.api.entity.Author;
import br.com.chronicles.api.repository.AuthorRepository;

@Service
public class AuthorService {

	@Autowired
	AuthorRepository authorRepository;

	public AuthorDetailsDTO register(AuthorRegisterDTO dto) {
		return new AuthorDetailsDTO(authorRepository.save(new Author().registrar(dto)));
	}

	public AuthorDetailsDTO update(AuthorUpdateDTO dto, Long id) {
		return new AuthorDetailsDTO(authorRepository.save(findById(id).update(dto)));
	}

	public List<AuthorDetailsDTO> findAll() {
		return authorRepository.findAllActive().stream().map(AuthorDetailsDTO::new).collect(Collectors.toList());
	}

	public void disable(Long id) {
		authorRepository.save(findById(id).disable());
	}

	public void active(Long id) {
	    Author author = findById(id);
	    if (!author.getIsActive()) {
	        authorRepository.save(author.active());
	    }
	}
	
	private Author findById(Long id) {
		return authorRepository.findById(id).orElseThrow(() -> new RuntimeException("Autor não encontrado"));
	}
	
}
