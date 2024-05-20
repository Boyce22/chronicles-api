package br.com.chronicles.controller;

import java.util.List;

import br.com.chronicles.interfaces.ReaderServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.chronicles.model.request.ReaderRegisterDTO;
import br.com.chronicles.model.request.ReaderUpdateDTO;
import br.com.chronicles.model.response.ReaderDetailsDTO;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/reader")
public class ReaderController {
	
	private final ReaderServiceImpl readerService;
	
	public ReaderController(ReaderServiceImpl readerService) {
		this.readerService = readerService;
	}
	
	@GetMapping("/findAll")
	public ResponseEntity<List<ReaderDetailsDTO>> findAll() {
		List<ReaderDetailsDTO> readers = readerService.findAll();
		return readers.isEmpty() ? ResponseEntity.notFound().build() : ResponseEntity.ok(readers);
	}
	
	@PostMapping("/register")
	public ResponseEntity<ReaderDetailsDTO> register(@Valid @RequestBody ReaderRegisterDTO dto){
		return ResponseEntity.ok(readerService.register(dto));
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
