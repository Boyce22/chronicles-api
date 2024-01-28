package br.com.chronicles.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.chronicles.api.dto.AuthorDetailsDTO;
import br.com.chronicles.api.dto.AuthorRegisterDTO;
import br.com.chronicles.api.dto.AuthorUpdateDTO;
import br.com.chronicles.api.service.AuthorService;
import jakarta.validation.Valid;

@RequestMapping("/author")
@RestController
public class AuthorController {

	@Autowired
	private AuthorService authorService;

	@GetMapping("/findAll")
	public ResponseEntity<List<AuthorDetailsDTO>> findAll() {
		List<AuthorDetailsDTO> authors = authorService.findAll();
		return authors.isEmpty() ? ResponseEntity.notFound().build() : ResponseEntity.ok(authors);
	}

	@PostMapping("/register")
	public ResponseEntity<String> registerAuthor(@RequestBody @Valid AuthorRegisterDTO dto,
			UriComponentsBuilder uriBuilder) {
		AuthorDetailsDTO author = authorService.register(dto);
		String message = "Autor registrado com sucesso!";
		return ResponseEntity.created(uriBuilder.path("author/{id}").buildAndExpand(author.id()).toUri()).body(message);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<AuthorDetailsDTO> updateAuthor(@RequestBody AuthorUpdateDTO dto, @PathVariable Long id) {
		return ResponseEntity.ok(authorService.update(dto, id));
	}
	
	@PutMapping("/active/{id}")
	public ResponseEntity<AuthorDetailsDTO> activeAuthor(@PathVariable Long id) {
		authorService.active(id);
		return ResponseEntity.noContent().build();
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteAuthor(@PathVariable Long id) {
		authorService.disable(id);
		return ResponseEntity.noContent().build();
	}

}
