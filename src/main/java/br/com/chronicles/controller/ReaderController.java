package br.com.chronicles.controller;

import java.util.List;

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

import br.com.chronicles.interfaces.IReaderService;
import br.com.chronicles.model.request.ReaderRegisterDTO;
import br.com.chronicles.model.request.ReaderUpdateDTO;
import br.com.chronicles.model.response.ReaderDetailsDTO;
import jakarta.validation.Valid;

@RequestMapping("/reader")
@RestController
public class ReaderController {
	
	private final IReaderService readerService;
	
	public ReaderController(IReaderService readerService) {
		this.readerService = readerService;
	}
	
	@GetMapping("/findAll")
	public ResponseEntity<List<ReaderDetailsDTO>> findAll() {
		List<ReaderDetailsDTO> readers = readerService.findAll();
		return readers.isEmpty() ? ResponseEntity.notFound().build() : ResponseEntity.ok(readers);
	}
	
	@PostMapping("/register")
	public ResponseEntity<ReaderDetailsDTO> register(@Valid @RequestBody ReaderRegisterDTO dto, UriComponentsBuilder uriBuilder){
		ReaderDetailsDTO reader = readerService.register(dto);
		return ResponseEntity.created(uriBuilder.path("reader/{id}").buildAndExpand(reader.id()).toUri()).body(reader);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<ReaderDetailsDTO> update(@PathVariable Long id, @RequestBody ReaderUpdateDTO dto){
		return ResponseEntity.ok(readerService.update(dto, id));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		readerService.delete(id);
		return ResponseEntity.noContent().build();
	}

	
}
