package br.com.chronicles.api.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.chronicles.api.dto.WorkCreateDTO;
import br.com.chronicles.api.dto.WorkDetailsDTO;
import br.com.chronicles.api.interfaces.IWorkService;

@RestController
@RequestMapping("/work")
public class WorkController {
	
	private final IWorkService workService;
	
	public WorkController(IWorkService workService) {
		this.workService = workService;
	}

	@PostMapping("/create")
	public ResponseEntity<String> create(@RequestBody WorkCreateDTO dto, UriComponentsBuilder uriBuilder) {
		String message = "Obra postada com sucesso!";
		WorkDetailsDTO work = workService.create(dto);
		return ResponseEntity.created(uriBuilder.path("work/{id}").buildAndExpand(work.id()).toUri()).body(message);
	}

}
