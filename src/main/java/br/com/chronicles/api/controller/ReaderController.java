package br.com.chronicles.api.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.chronicles.api.dto.ReaderDetailsDTO;
import br.com.chronicles.api.dto.ReaderUpdateDTO;
import br.com.chronicles.api.interfaces.IReaderService;

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
	
//	@PostMapping("/register")
//	public ResponseEntity<String> register(@Valid @RequestBody ReaderRegisterDTO dto, UriComponentsBuilder uriBuilder){
//		String message = "Leitor registrado com sucesso!";
//		ReaderDetailsDTO reader = readerService.register(dto);
//		return ResponseEntity.created(uriBuilder.path("reader/{id}").buildAndExpand(reader.id()).toUri()).body(message);
//	}
	
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
