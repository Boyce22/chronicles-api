package br.com.chronicles.controller;

import java.util.List;

import br.com.chronicles.interfaces.AuthorServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.chronicles.model.request.AuthorRegisterDTO;
import br.com.chronicles.model.request.AuthorUpdateDTO;
import br.com.chronicles.model.response.AuthorDetailsDTO;
import br.com.chronicles.model.response.DefaultResponse;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/author")
public class AuthorController {

	private final AuthorServiceImpl authorService;

	public AuthorController(AuthorServiceImpl authorService) {
		this.authorService = authorService;
	}

	@GetMapping("/findAll")
	public ResponseEntity<List<AuthorDetailsDTO>> findAll() {
		List<AuthorDetailsDTO> authors = authorService.findAll();
		return authors.isEmpty() ? ResponseEntity.notFound().build() : ResponseEntity.ok(authors);
	}

	@GetMapping("/reference/{reference}")
	public ResponseEntity<List<AuthorDetailsDTO>> findByReference(@PathVariable String reference) {
		return ResponseEntity.ok(authorService.findByReference(reference));
	}

	@PostMapping("/register")
	public ResponseEntity<AuthorDetailsDTO> registerAuthor(@RequestBody @Valid AuthorRegisterDTO dto) {
		return ResponseEntity.ok(authorService.register(dto));
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<AuthorDetailsDTO> updateAuthor(@RequestBody AuthorUpdateDTO dto, @PathVariable Long id) {
		return ResponseEntity.ok(authorService.update(dto, id));
	}

	@PutMapping("/active/{id}")
	public ResponseEntity<DefaultResponse> activeAuthor(@PathVariable Long id) {
		return ResponseEntity.ok(authorService.active(id));
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<DefaultResponse> deleteAuthor(@PathVariable Long id) {
		return ResponseEntity.ok(authorService.disable(id));
	}

}
