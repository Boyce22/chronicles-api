package br.com.chronicles.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.chronicles.interfaces.IWorkService;
import br.com.chronicles.model.request.WorkCreateDTO;
import br.com.chronicles.model.response.WorkDetailsDTO;

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
